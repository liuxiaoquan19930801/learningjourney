package com.java.basic.multiThread;

public class ThreadTest009_Synchronized {
    public static void main(String[] args){
        Object lock = new Object();
        PrintThread printThread1 = new PrintThread(lock,"print1");
        PrintThread printThread2 = new PrintThread(lock,"print2");
        new Thread(printThread1).start();
        new Thread(printThread2).start();
    }
}

class PrintThread implements Runnable{
    
    private Object lock;
    private String string;
    private int i = 0;
    
    public PrintThread(Object lock,String printString){
        this.lock = lock;
        this.string = printString;
    }
    
    @Override
    public void run() {
        while (i < 500){
            synchronized (lock){
                System.out.println(string);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
        }
    }
}