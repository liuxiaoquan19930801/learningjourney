package com.java.basic.demos.test;
/**
 * 此代码模拟实现了equals方法来比对两个对象是否等价。
 * @author liuxq
 *
 */
public class EqualsTest {
	private char value[];
	private int count ;

	public EqualsTest(char[] value) {
		super();
		this.value = value;
		this.count = value.length;
	}

	public EqualsTest() {
		super();
	}

	public char[] getValue() {
		return value;
	}

	public void setValue(char[] value) {
		this.value = value;
	}

	public int getCount() {
		return count;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj instanceof EqualsTest) {
			EqualsTest o = (EqualsTest) obj;
			if (this.count != o.count) {
				return false;
			}
			int len = this.count;
			char ob[] = o.value;
			for (int i = 0; i < len - 1; i++) {
				if (this.value[i] != ob[i]) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		char a[] = {'a','b'};
		char b[] = {'1','2'};
		char c[] = {'a','b'};
		EqualsTest eqTest1 = new EqualsTest(a);
		EqualsTest eqTest2 = new EqualsTest(c);
		
		System.out.println(eqTest1.equals(a));
		System.out.println(eqTest1.equals(b));
		System.out.println(eqTest1.equals(c));
		System.out.println(eqTest1.equals(eqTest2));
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
	}
}
