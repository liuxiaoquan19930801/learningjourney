package com.java.basic.multiThread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest014_AtomicTest {
    
    private AtomicInteger count = new AtomicInteger();
    
    public static void main(String[] args){
        ThreadTest014_AtomicTest threadTest014_atomicTest = new ThreadTest014_AtomicTest();
        for(int i = 0;i < 10;i++){
            new Thread(() -> {
                while (true){
                    threadTest014_atomicTest.count.getAndIncrement();
                    System.out.println(threadTest014_atomicTest.count.get());
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
