package com.cloud.datacontrol.design.impl;

import com.cloud.datacontrol.design.Logger;

public class SimpleLogger implements Logger {
    @Override
    public void print(int level, String msg) {
        System.out.println(msg);
    }

    @Override
    public void println(int level, String msg) {
        System.out.println(msg);
    }

    @Override
    public void logException(Throwable e) {
        e.printStackTrace();
    }
}
