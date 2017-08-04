package com.java.basic.multiThread;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest003_ReentrantLock implements Runnable{
	
	private ReentrantLock rlock = new ReentrantLock();
	private Fooo foo = new Fooo();
	
	public int fix(int y){
		return foo.fix(y);
	}

	@Override
	public void run(){
		rlock.lock();
		rlock.lock();
		for(int i=0;i<3;i++){
			this.fix(i);
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				System.out.println(e);
			}
			System.out.println(Thread.currentThread().getName() + "��ǰfoo�����xֵ��"
					+ this.foo.getX());
		}
		
		rlock.unlock();
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