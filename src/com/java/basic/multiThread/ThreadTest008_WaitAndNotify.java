package com.java.basic.multiThread;

/**
 * 该示例中，因为在main主线程中调用了Output方法，输出字符串后，进入了wait,主线程后续的创建线程的代码无法执行，
 * 所以主线程挂起，后续不会再有任何输出。
 */
public class ThreadTest008_WaitAndNotify {
    
    public static void main(String[] args) throws InterruptedException {
        ThreadTest008_WaitAndNotify threadTest008_waitAndNotify = new ThreadTest008_WaitAndNotify();
        Object lock = new Object();
        threadTest008_waitAndNotify.Output(lock);
        System.out.println("test");
        SubOutput subOutput = new SubOutput();
        subOutput.setLock(lock);
        new Thread(subOutput).start();
    }
    
    public void Output(Object lock) throws InterruptedException {
        synchronized (lock){
            lock.notifyAll();
            System.out.println("output");
            lock.wait();
            System.out.println("main");
        }
    }
}

class SubOutput implements Runnable{
    
    private Object lock;
    
    public void setLock(Object lock) {
        this.lock = lock;
    }
    
    @Override
    public void run() {
        synchronized (lock){
            lock.notifyAll();
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sub");
        }
    }
}