package com.java.basic.demos.test;

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

}
