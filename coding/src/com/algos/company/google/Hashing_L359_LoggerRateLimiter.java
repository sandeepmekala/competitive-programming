package com.algos.company.google;

import java.util.HashMap;
import java.util.Map;

public class Hashing_L359_LoggerRateLimiter {
    public static void main(String[] args) {
        Hashing_L359_LoggerRateLimiter obj = new Hashing_L359_LoggerRateLimiter();
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(2, "foo"));
        System.out.println(logger.shouldPrintMessage(2, "bar"));
        System.out.println(logger.shouldPrintMessage(11, "foo"));
    }
}

class Logger {

    private Map<String, Integer> limiter;

    // Problem: https://leetcode.ca/2018-12-05-359-Logger-Rate-Limiter/
    public Logger() {
        limiter = new HashMap<>();
    }

    /**
       Returns true if the message should be printed in the given timestamp, otherwise returns
       false. If this method returns false, the message will not be printed. The timestamp is in
       seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int expTime = limiter.getOrDefault(message, 0);
        if (expTime > timestamp)
            return false;

        limiter.put(message, timestamp + 10);
        return true;
    }
}
