package com.cloud.datacontrol.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/multithreading")
public class Multithreading {

    @Autowired
    private ImportMysql importMysql;

    @GetMapping
    public void Multithreading() {
        // 开始处理的时间
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        while (importMysql.readCUser()) {
            executorService.execute(() -> importMysql.writ());
        }
        //关闭线程
        executorService.shutdown();
        //是否终止
        boolean terminated = executorService.isTerminated();
        //等待线程池中的线程执行完
        while (!terminated) {

        }
        // 结束时间
        long endTime = System.currentTimeMillis();
        // 总耗时
        System.out.println("total handle time:" + (endTime - startTime) + "ms");
    }

}
