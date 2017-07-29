package com.java.basic.designpattern.test;

import org.junit.Test;
import com.java.basic.designpattern.singleton.Singleton1;
import com.java.basic.designpattern.singleton.Singleton2;

public class SingletonTest {

	@Test
	public void SingletonTest1(){
		//饿汉模式
		Singleton1 sl1 = Singleton1.getInstance();
		Singleton1 sl2 = Singleton1.getInstance();
		System.out.println(sl1 == sl2);
	}
	
	@Test
	public void SingletonTest2(){
		//懒汉模式
		Singleton2 sl3 = Singleton2.getInstance();
		Singleton2 sl4 = Singleton2.getInstance();
		System.out.println(sl3 == sl4);

		Singleton2 sl5 = Singleton2.getInstance();
		Singleton2 sl6 = Singleton2.getInstance();
		System.out.println(sl5 == sl6);
		System.out.println(sl3 == sl5);
	}
	
}
