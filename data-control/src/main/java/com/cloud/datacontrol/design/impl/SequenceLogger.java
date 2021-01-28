package com.cloud.datacontrol.design.impl;

import com.cloud.datacontrol.design.LoggerOne;

public class SequenceLogger implements LoggerOne {


    @Override
    public void println(int level, String msg) {
        for(LoggerOne l: loggers){
            l.println(level, msg);
        }
    }

    @Override
    public void printException(Throwable a) {
        for (LoggerOne l:loggers){
            l.printException(a);
        }
    }

    @Override
    public void print(int level, String msg) {

    }

    private final LoggerOne[] loggers;
    SequenceLogger(LoggerOne[] ls){
        this.loggers = ls;
    }
}
