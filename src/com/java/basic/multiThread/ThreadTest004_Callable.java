package com.java.basic.multiThread;

import sun.util.resources.th.CalendarData_th;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest004_Callable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for(;i<100;i++){
            System.out.println(Thread.currentThread().getName() + " " +i);
            Thread.sleep(1000);
        }

        return i;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest004_Callable threadTest004_callable = new ThreadTest004_Callable();
        FutureTask<Integer> futureTask = new FutureTask<>(threadTest004_callable);

        for (int i = 0;i < 100;i++){
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if (i == 20){
                new Thread(futureTask,"有返回值的线程").start();
            }
            Thread.sleep(1000);
        }
        try {
            System.out.println("子线程的返回值" + futureTask.get());
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
    }

}
