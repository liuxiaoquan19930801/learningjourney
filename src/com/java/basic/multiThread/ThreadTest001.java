package com.java.basic.multiThread;

public class ThreadTest001 extends Thread {
	
	public ThreadTest001(String string)
	{
		super.setName(string);
	}

	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(this.getName() + i);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadTest001 a = new ThreadTest001("Tom");
        ThreadTest001 c = new ThreadTest001("Henry");
        ThreadTest001 d = new ThreadTest001("Fuck");
		ThreadTest001 b = new ThreadTest001("Jack");
//		System.out.println("a==b? |" + (a == b));
//		System.out.println("a.equals(b) |" + (a.equals(b)));
		a.start();
        a.join();
		b.start();
        c.start();
        d.start();
	}
	
}
