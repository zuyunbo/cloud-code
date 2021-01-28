package com.cloud.datacontrol.design;

public interface LoggerOne {

    void println(int level, String msg);

    void printException(Throwable a);

    void print(int level,String msg);



}
