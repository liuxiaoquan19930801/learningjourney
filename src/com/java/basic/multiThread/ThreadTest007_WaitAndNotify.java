package com.java.basic.multiThread;

/**
 * 示例中，主线程一直流畅的执行，完成了两个线程的创建.
 * 第一个线程创建后wait了,未进行输出。输出是在第二个线程执行的时候调用了notifyAll是第一个线程唤醒了才输出的。
 */
public class ThreadTest007_WaitAndNotify {
    public static void main(String[] args){
        final Object lock= new Object();
        Thread thread1 = new Thread(new OutputThread(1,lock));
        Thread thread2 = new Thread(new OutputThread(2,lock));
        thread1.start();
        thread2.start();
    }
}

class OutputThread implements Runnable{
    
    private int num;
    private Object lock;
    
    public OutputThread(int num,Object lock){
        super();
        this.num = num;
        this.lock = lock;
    }
    
    @Override
    public void run() {
        try {
            while (true){
                synchronized (lock){
                    lock.notifyAll();
                    lock.wait();
                    System.out.println(num);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}