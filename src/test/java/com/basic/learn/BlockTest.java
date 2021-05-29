package com.basic.learn;

import org.junit.Test;

public class BlockTest {
//    @Test
//    public void blockedTest() throws InterruptedException {
//
//        Thread a = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                testMethod();
//            }
//        }, "a");
//        Thread b = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                testMethod();
//            }
//        }, "b");
//
//        a.start();
//        a.join();
//        b.start();
//        System.out.println(a.getName() + ":" + a.getState()); // 输出 TERMINATED
//        System.out.println(b.getName() + ":" + b.getState());
//
//    }

    // 同步方法争夺锁
    private synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    private static Object lock = new Object();
    static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread A " + i);
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread B " + i);
                }
            }
        }
    }

    @Test
    public void test1() throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(1);
        new Thread(new ThreadB()).start();
    }
}
