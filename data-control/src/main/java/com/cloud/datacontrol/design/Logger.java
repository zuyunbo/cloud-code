package com.cloud.datacontrol.design;

public interface Logger {

    void print(int level,String msg);

    void println(int level, String msg);

    void logException(Throwable e);


}
