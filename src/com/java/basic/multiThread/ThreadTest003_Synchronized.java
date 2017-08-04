package com.java.basic.multiThread;

public class ThreadTest003_Synchronized implements Runnable{

	private Foo foo = new Foo();
	
	public int fix(int y){
		return foo.fix(y);
	}
	
	@Override
	public synchronized void run(){
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
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest003_Synchronized r = new ThreadTest003_Synchronized();
		Thread ta = new Thread(r,"Thread-A");
		Thread tb = new Thread(r,"Thread-B");
		
		ta.start();
		tb.start();
	}

}

class Foo{
	private int x = 100;
	
	public int getX(){
		return x;
	}
	
	public int fix(int y){
		x = x-y;
		return x;
	}
}