package ru.job4j.io;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        BasicConfigurator.configure();
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
        byte b = 1;
        short s = 9;
        char c = 'c';
        int i = 10;
        long l = 100L;
        float f = 3.14f;
        double d = 5.12;
        boolean bool = true;
        LOG.debug("Примитивные типы данных. "
                + "byte : {}, short : {}, char : {}, int : {}, long : {}, float : {}, double : {}, boolean : {}",
                b, s, c, i, l, f, d, bool);
    }
}
