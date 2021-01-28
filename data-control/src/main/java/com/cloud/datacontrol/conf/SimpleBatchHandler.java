package com.cloud.datacontrol.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class SimpleBatchHandler {

    private ExecutorService executorService = Executors.newFixedThreadPool(20);

    @Autowired
    private MockService service;
    /**
     * 每次批量读取的数据量
     */
    private int batch = 5;

    /**
     * 开始处理
     */
    public void startHandle() {
        // 开始处理的时间
        long startTime = System.currentTimeMillis();
        System.out.println("start handle time:" + startTime);
        long readData;
        // 批量读取数据，知道读取不到数据才停止
        while ((readData = service.readData(batch)) != 0) {
            for (long i = 0; i < readData; i++) {
                executorService.execute(() -> service.writeData());
            }
        }
        // 关闭线程池
        executorService.shutdown();
        //等待线程池中的线程执行完
        while (!executorService.isTerminated()) {

        }
        // 结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("end handle time:" + endTime);
        // 总耗时
        System.out.println("total handle time:" + (endTime - startTime) + "ms");
        // 写入总数
        System.out.println("total write num:" + service.getWriteTotal());
    }

}
