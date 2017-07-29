package com.java.basic.multiThread;

public class ThreadTest002B {

	public static void main(String[] args){
		
		ThreadTest002A a = new ThreadTest002A("Herry");
		ThreadTest002A b = new ThreadTest002A("Willim");
		
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);

		t1.start();
		t2.start();
	}
}
