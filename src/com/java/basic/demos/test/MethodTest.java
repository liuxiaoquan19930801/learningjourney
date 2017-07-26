package com.java.basic.demos.test;

import org.junit.Test;

public class MethodTest {
	
	@Test
	public void birthdayTheSame(){
		int n = 30;
		double x = 100;
		for(int i =0;i < n;i++){
			x *= (365.0 - i)/365;
		}
		System.out.println(100.0-x);
	}
	
}
