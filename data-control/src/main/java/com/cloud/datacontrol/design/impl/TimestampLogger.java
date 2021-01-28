package com.cloud.datacontrol.design.impl;

import com.cloud.datacontrol.design.LoggerOne;

import java.util.Date;

public class TimestampLogger implements LoggerOne {


    private final LoggerOne logger;
    private boolean freshline = true;


    private void printTimestamp(int level){
        if(freshline){
            logger.print(level, new Date().toString()+": ");
        }
    }

    @Override
    public void println(int level, String msg) {
        printTimestamp(level);
        logger.println(level,msg);
        freshline = true;
    }

    @Override
    public void print(int level, String msg){
        printTimestamp(level);
        logger.print(level, msg);
        freshline = false;
    }

    @Override
    public void printException(Throwable e){
        printTimestamp(1);
        logger.printException(e);
        freshline = true;
    }

    public TimestampLogger(LoggerOne logger) {
        this.logger = logger;
    }
}
