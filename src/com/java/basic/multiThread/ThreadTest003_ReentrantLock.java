package com.java.basic.multiThread;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest003_ReentrantLock implements Runnable{
	
	private ReentrantLock rlock = new ReentrantLock();
	private Fooo foo = new Fooo();
	
	public int fix(int y){
		return foo.fix(y);
	}

	/*此方法不使用synchronized关键字修饰， 采用ReentrantLock锁机制，
	 * 因此处三次调用fix方法，不能把锁加在fix方法上。
	 */
	@Override
	public void run(){
		rlock.lock();
		for(int i=0;i<3;i++){
			this.fix(i);
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				System.out.println(e);
			}
			System.out.println(Thread.currentThread().getName() + "当前foo对象的x值："
					+ this.foo.getX());
		}
		rlock.unlock();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest003_ReentrantLock r = new ThreadTest003_ReentrantLock();
		Thread ta = new Thread(r,"Thread-A");
		Thread tb = new Thread(r,"Thread-B");
		
		ta.start();
		tb.start();
	}

}

//一个java文件可以有多个class类，但只允许有一个public class
class Fooo{
	private int x = 100;
	
	public int getX(){
		return x;
	}
	
	public int fix(int y){
		x = x-y;
		return x;
	}
}