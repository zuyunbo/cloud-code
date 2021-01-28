package com.cloud.datacontrol.design.config;

import com.cloud.datacontrol.design.LoggerOne;
import com.cloud.datacontrol.design.impl.FilteredLogger;
import com.cloud.datacontrol.design.impl.NopLogger;
import com.cloud.datacontrol.design.impl.WriterLogger;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Loggers {

    static LoggerOne nop() {
        return new NopLogger();
    }

    static LoggerOne writer(PrintWriter writer) {
        return new WriterLogger(writer);
    }

    static LoggerOne writer(OutputStream out) {
        return writer(new PrintWriter(out, true));
    }

    static LoggerOne filter(LoggerOne l1, LoggerOne l2, int lvl) {
        return new FilteredLogger(l1, l2, lvl);
    }


}
