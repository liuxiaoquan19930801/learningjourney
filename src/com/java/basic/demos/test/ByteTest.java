package com.java.basic.demos.test;

import org.junit.Test;

public class ByteTest {

	/**
	 * Byte类型值的运算
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Byte A = -64;
		Byte B = -6;
		System.out.println("A/B=" + A/B + " A%B=" + A%B);
		
		System.out.println(1<<16);
		
		System.out.println(65536>>>16);
		
		int h = 1;
        System.out.println(h + (h <<  15) ^ 0xffffcd7d);
        System.out.println(h ^ (h >>> 10));
        System.out.println(h + (h <<   3));
        System.out.println(h ^ (h >>>  6));
        System.out.println(h + (h <<   2) + (h << 14));
        System.out.println(h ^ (h >>> 16));
	}
	
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
	public void ReSortTest(){
		System.out.println(f(5));
		
	}
	
	public int f(int n){
		if(n==1){return 0;}
		if(n==2) {return 1;}
		
		return (n-1)*(f(n-1)+f(n-2));
	}

}
