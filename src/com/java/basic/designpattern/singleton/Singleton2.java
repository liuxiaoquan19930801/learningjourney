package com.java.basic.designpattern.singleton;
/**
 * ����ģʽ������ģʽ
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
