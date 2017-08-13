package com.java.basic.multiThread;

/**
 * 此测试为执行顺序测试
 */
public class ThreadTest005 {
    
    Thread t = new Thread(new OutThread());
    
    public static void main(String[] args) throws InterruptedException {
        ThreadTest005 threadTest005  = new ThreadTest005();
        System.out.println("main0");
        threadTest005.t.start();
//        Thread.sleep(1000);
        System.out.println("main1");
    
        try {
            threadTest005.t.join();
            System.out.println("main2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
    }
    
}

class OutThread implements Runnable{
    @Override
    public void run(){
        System.out.println("outThread");
    }
}