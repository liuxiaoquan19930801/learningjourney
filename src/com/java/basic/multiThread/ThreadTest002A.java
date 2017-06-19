package com.java.basic.multiThread;

public class ThreadTest002A implements Runnable{

	private String name;

	public ThreadTest002A(){
		
	}
	
	public ThreadTest002A(String string){
		this.setName(string);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(this.getName() + i);
		}
	}

}
