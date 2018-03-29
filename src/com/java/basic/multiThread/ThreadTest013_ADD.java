package com.java.basic.multiThread;

public class ThreadTest013_ADD {
    private int i = 0;
    
    public synchronized int printI(){
        return i++;
    }
    
    public static void main(String[] args){
        ThreadTest013_ADD threadTest013_add = new ThreadTest013_ADD();
        for(int i = 0;i < 10;i++){
            new Thread(() -> {
                while (true){
                    System.out.println(Thread.currentThread().getName() + " : " + threadTest013_add.printI());
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
