package com.cloud.datacontrol.conf;

import com.cloud.datacontrol.entity.CUser;
import com.cloud.datacontrol.mapper.CUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class MockService {


    @Autowired
    CUserMapper cUserMapper;

    /**
     * 可读取总数
     */
    private long canReadTotal = 3000;

    /**
     * 写入总数
     */
    private AtomicLong writeTotal = new AtomicLong(0);

    /**
     * 写入休眠时间（单位：毫秒）
     */
    private final long sleepTime = 300;


    /**
     * 批量读取数据接口
     *
     * @param num
     * @return
     */
    public synchronized long readData(int num) {
        long readNum;
        if (canReadTotal >= num) {
            canReadTotal -= num;
            readNum = num;
        } else {
            readNum = canReadTotal;
            canReadTotal = 0;
        }
        return readNum;
    }

    /**
     * 写入数据接口
     */
    public void writeData() {

        for (int x = 0; x < 1000; x++) {
            CUser cUser = new CUser();
            cUser.setCreatedBy(1L);
            cUser.setName(String.valueOf(System.currentTimeMillis()));
            cUser.setPassword(Thread.currentThread().toString()+writeTotal.incrementAndGet());
            cUser.setUrl(Thread.currentThread().toString());
            cUser.setUsername(String.valueOf(System.currentTimeMillis()));
            cUserMapper.insert(cUser);
            System.out.println("thread:" + Thread.currentThread() + " write data:" + writeTotal.incrementAndGet());
        }
    }

    /**
     * 获取写入的总数
     *
     * @return
     */
    public long getWriteTotal() {
        return writeTotal.get();
    }


}
