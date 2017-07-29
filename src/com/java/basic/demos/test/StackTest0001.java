package com.java.basic.demos.test;

public class StackTest0001 {
	
	public void createOther(){
		MyClass myclass = new MyClass();
		myclass.print();
	}
	
	public static void main(String[] args){
		StackTest0001 st = new StackTest0001();
		st.createOther();
		MyClass.printB();
	}
	
	
}

class MyClass{
	public int myint;
	
	public static void printB(){
		System.out.println("MyClass is here");
	}
	
	MyClass(){
		System.out.println("class is created and myit=" + myint);
	}
	
	public void print(){
		System.out.println("MyClass here.");
	}
}