package com.leo.thread.cas;


import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {
    private static int not_safe_count = 0;
    private static int safe_count = 0;
    private static final AtomicInteger count = new AtomicInteger(0);
    private static final int times = 100000;
    private static final int threadNums = 2;

    public static void main(String[] args) {
        notSafeCounter();
        safeCounter();
        casCounter();
    }

    @SneakyThrows
    private static void casCounter() {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                //每个线程让count自增 100000 次
                for (int i1 = 0; i1 < times; i1++) {
                    count.incrementAndGet();
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println("cas: " + count);
    }

    @SneakyThrows
    private static void safeCounter() {
        for (int i = 0; i < threadNums; i++) {
            new Thread(() -> {
                //每个线程让count自增 100000 次
                for (int i1 = 0; i1 < times; i1++) {
                    synchronized (CASTest.class) {
                        safe_count++;
                    }
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println("synchronized: " +safe_count); //等于 times * threadNums
    }

    @SneakyThrows
    private static void notSafeCounter() {
        for (int i = 0; i < threadNums; i++) {
            new Thread(() -> {
                //每个线程让 count 自增 100000 次
                for (int i1 = 0; i1 < times; i1++) {
                    not_safe_count++;
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(not_safe_count); // 不等于 times * threadNums
    }
}
