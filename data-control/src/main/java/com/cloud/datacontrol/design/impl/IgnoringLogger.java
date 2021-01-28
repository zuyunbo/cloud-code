package com.cloud.datacontrol.design.impl;

import com.cloud.datacontrol.design.LoggerOne;

public class IgnoringLogger  implements LoggerOne {
    private final LoggerOne logger1;
    private final LoggerOne logger2;
    private final int lvl;

    @Override
    public void println(int level, String msg) {
        if(level>=lvl)logger1.println(level, msg);
        else logger2.println(level, msg);
    }

    @Override
    public void printException(Throwable e) {
        if(lvl<=1) logger1.printException(e);
        else logger2.printException(e);
    }

    @Override
    public void print(int level, String msg) {

    }

    public IgnoringLogger(LoggerOne logger1, LoggerOne logger2, int lvl) {
        this.logger1 = logger1;
        this.logger2 = logger2;
        this.lvl = lvl;
    }
}
