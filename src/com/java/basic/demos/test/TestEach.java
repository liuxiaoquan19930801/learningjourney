package com.java.basic.demos.test;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;

public class TestEach {
	
	@Test
	public void testWrite(){
		System.out.println("��ʼʱ�䣺" + new Date());
		String path = "D:\\randomString.txt";
		Write write = new Write();
		CreateRandomValue ranstr = new CreateRandomValue();
		for(int i=0;i<10000;i++){
			for(int j=0;j<10000;j++){
				write.WriteToFlie(path, ranstr.getRandomString(10));
			}
		}
		write.closeOutputStream();
		System.out.println("����ʱ�䣺" + new Date());
	}
	
	@Test
	public void cutBigFile(){
		Write write = new Write();
		try {
			write.cutBigFile("D:\\randomString.txt","D:\\targetFile\\", 100);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
