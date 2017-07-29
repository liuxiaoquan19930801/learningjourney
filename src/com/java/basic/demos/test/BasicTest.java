package com.java.basic.demos.test;

import org.junit.Test;

/**
 * 各种基础知识测试
 */

public class BasicTest {

	//求解50个人中有两个生日相同的概率
	@Test
	public void birthdayTheSame(){
		int n = 30;
		double x = 100;
		for(int i =0;i < n;i++){
			x *= (365.0 - i)/365;
		}
		System.out.println(100.0-x);
	}

	//自增优先级演示
	@Test
	public void addSelfTest(){
		int x =0;
		switch (++x) {
			case 0:	System.out.println(x);++x;System.out.println(x);
			case 1:	System.out.println(x);++x;System.out.println(x);
			case 2:	System.out.println(x);++x;System.out.println(x);
		}
	}

	@Test
	public void commonTest001(){
		System.out.println(0.3*10 == 3);
		System.out.println("abc"== new String("abc").toString());
	}
	
}
