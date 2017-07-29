package com.java.basic.designpattern.singleton;
/**
 * 单例模式：饿汉模式
 * @author Administrator
 *
 */
public class Singleton1 {
	
	private Singleton1(){
		
	}
	
	private static Singleton1 instance = new Singleton1();
	
	public static Singleton1 getInstance(){
		return instance;
	}
}
