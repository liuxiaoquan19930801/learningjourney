package com.java.basic.multiThread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ThreadTest012_ProducerConsumer {
    public static void main(String[] args){
        System.out.println("ProducerConsumerInJava:");
        Queue<Integer> queue = new LinkedList<Integer>();
        int maxSize = 10;
        Producer producer = new Producer(queue,maxSize,"Producer");
        Consumer consumer = new Consumer(queue,maxSize,"Consumer");
        producer.start();
        consumer.start();
    }
}


class Producer extends Thread{
    private Queue<Integer> queue;
    private int maxSize;
    
    public Producer(Queue<Integer> queue,int maxSize,String threadName){
        super(threadName);
        this.queue = queue;
        this.maxSize = maxSize;
    }
    
    @Override
    public void run(){
        while(true){
            synchronized (queue){
                while (queue.size() == maxSize){
                    System.out.println("Queue is full.");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Random random = new Random();
                int i = random.nextInt();
                System.out.println("Produceing value:" + i);
                queue.add(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.notifyAll();
            }
        }
    }
}

class Consumer extends Thread{
    private Queue<Integer> queue;
    private int maxSize;
    
    public Consumer(Queue<Integer> queue,int maxSize,String threadName){
        super(threadName);
        this.queue = queue;
        this.maxSize = maxSize;
    }
    
    @Override
    public void run(){
        while(true){
            synchronized (queue){
                while (queue.isEmpty()){
                        System.out.println("Queue is empty.");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                System.out.println("Cosuming value :" + queue.remove());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.notifyAll();
            }
        }
    }
}