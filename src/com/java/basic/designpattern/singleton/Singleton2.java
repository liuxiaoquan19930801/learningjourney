package com.java.basic.designpattern.singleton;
/**
 * 懒汉模式
 * @author Administrator
 *
 */
public class Singleton2 {

	private Singleton2(){
		
	}
	
	private static Singleton2 instance;
	
	public static Singleton2 getInstance(){
		return instance == null?instance = new Singleton2():instance;
	}
}
