package com.java.basic.multiThread;

import java.util.concurrent.SynchronousQueue;

/**
 * 此例证明了notify和notifyAll唤醒的线程是等待该对象锁的所有线程，并是不唤醒所有所有线程。
 */
public class ThreadTest011_WaitAndNotify {
    public static void main(String[] args){
        Object lk1 = new Object();
        Object lk2 = new Object();
        
        Print011 print011a = new Print011(lk1,lk2,"lock1");
        Print011 print011b = new Print011(lk1,lk2,"lock2");
        new Thread(print011a).start();
        new Thread(print011b).start();
    }
}

class Print011 implements Runnable{
    
    private Object lock1;
    private Object lock2;
    private String lockFlag;
    
    public Print011(Object lock1,Object lock2,String lockFlag){
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.lockFlag = lockFlag;
    }
    
    @Override
    public void run() {
        if (this.lockFlag.equals("lock1")){
            synchronized (this.lock1){
                try {
                    System.out.println("print1-befor");
                    lock1.wait();
                    System.out.println("print1-after");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.lockFlag.equals("lock2")){
            synchronized (this.lock2){
                try {
                    System.out.println("print2-befor");
                    Thread.sleep(10000);
                    lock2.notifyAll();
                    System.out.println("print2-notifyAll");
                    lock2.wait();
                    System.out.println("print2-after");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
