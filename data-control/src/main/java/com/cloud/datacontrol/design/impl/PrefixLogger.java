package com.cloud.datacontrol.design.impl;

import com.cloud.datacontrol.design.Factory;
import com.cloud.datacontrol.design.Logger;
import com.cloud.datacontrol.design.LoggerOne;

public class PrefixLogger implements LoggerOne {

    private final LoggerOne logger;
    private final Factory factory;
    private boolean freshline = true;

    private void prefix(int lvl){
        if(freshline){
            Object r = factory.cretae();
            if(r!=null)
                logger.print(lvl, (String) r);
            freshline = false;
        }
    }


    @Override
    public void println(int level, String msg) {
        prefix(level);
        logger.print(level, msg);
    }

    @Override
    public void printException(Throwable a) {

    }

    @Override
    public void print(int level, String msg) {

    }

    public PrefixLogger(LoggerOne logger, Factory factory) {
        this.logger = logger;
        this.factory = factory;
    }
}
