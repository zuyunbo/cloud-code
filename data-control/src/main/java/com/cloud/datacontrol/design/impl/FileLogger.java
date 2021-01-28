package com.cloud.datacontrol.design.impl;

import com.cloud.datacontrol.design.LoggerOne;

public class FileLogger implements LoggerOne {

    @Override
    public void println(int level, String msg) {
        System.out.println("log by write file");
    }

    @Override
    public void printException(Throwable a) {
        System.out.println("log by write file Exception");
    }

    @Override
    public void print(int level, String msg) {

    }
}
