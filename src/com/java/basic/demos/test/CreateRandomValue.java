package com.java.basic.demos.test;

import java.util.Random;

import org.junit.Test;

public class CreateRandomValue {
	/**
	 * @param maxLen
	 * @return
	 */
	public String getRandomString(int maxLen){
		StringBuffer stringbuf = new StringBuffer("");
		Random ran = new Random();
		int leng = ran.nextInt(maxLen);
		for(int i=0;i<leng;){
			char chornum = ran.nextInt(2)%2 == 0?'n':'c';
			if(chornum == 'n'){
				stringbuf.append(ran.nextInt(10));
			}else{
				if(ran.nextInt(2) == 0){
					stringbuf.append((char)(ran.nextInt(26)+65));
				}else{
					stringbuf.append((char)(ran.nextInt(26)+97));
				}
			}
			i++;
		}
		return stringbuf.toString() + "\n";
	}
	
	@Test
	public void testGetRandom(){
		CreateRandomValue crea = new CreateRandomValue();
		System.out.println(crea.getRandomString(10));
	}
}
