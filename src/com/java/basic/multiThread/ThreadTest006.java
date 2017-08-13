package com.java.basic.multiThread;

import com.java.basic.datastructure.bplustree.B;

/**
 * 多线程输出,ABC按顺序输出10次
 */
public class ThreadTest006 {
    public static void main(String[] args){
        for(int i=0;i < 10;i++){
           Thread threadA = new Thread(() -> System.out.println("A"));
           threadA.start();
            Thread threadB = new Thread(() -> {
                try {
                    threadA.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B");
            });
            threadB.start();
            Thread threadC = new Thread(() -> {
                try {
                    threadB.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C");
            });
            threadC.start();
        }
    }
}
