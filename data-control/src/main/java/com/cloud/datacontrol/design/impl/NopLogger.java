package com.cloud.datacontrol.design.impl;

import com.cloud.datacontrol.design.LoggerOne;

public class NopLogger implements LoggerOne {
    @Override
    public void println(int level, String msg) {

    }

    @Override
    public void printException(Throwable a) {

    }

    @Override
    public void print(int level, String msg) {

    }
}
