package com.cloud.datacontrol.conf;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestUtil {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Asynchronous task");
            }
        });
        executorService.shutdown();


    }

}
