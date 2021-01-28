package com.cloud.datacontrol.design.impl;

import com.cloud.datacontrol.design.LoggerOne;

import java.io.PrintWriter;

public class ErrorMessageLogger implements LoggerOne {

    private final PrintWriter out;
    private final LoggerOne logger;

    @Override
    public void println(int level, String msg) {
        logger.println(level, msg);
    }

    @Override
    public void printException(Throwable a) {
        out.println(a.getMessage());
    }

    @Override
    public void print(int level, String msg) {

    }

    public ErrorMessageLogger(PrintWriter out, LoggerOne logger) {
        this.out = out;
        this.logger = logger;
    }
}
