package org.junitdemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,20, TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(10));

        executor.submit(() -> {});



    }
}