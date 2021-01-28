package com.cloud.datacontrol.design.impl;

import com.cloud.datacontrol.design.LoggerOne;

import java.io.PrintWriter;

public class WriterLogger implements LoggerOne {

    private final PrintWriter writer;

    public WriterLogger(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public void println(int level, String msg) {
        writer.println(msg);
    }

    @Override
    public void printException(Throwable a) {
        a.printStackTrace(writer);
    }

    @Override
    public void print(int level, String msg) {

    }
}
