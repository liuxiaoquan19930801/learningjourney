package com.java.basic.demos.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class HashMapTest {
	HashMap<String,Integer> hashmap = null;
	int maxThreeTimes=3;
	ArrayList<String> maxThreeString = new ArrayList<String>();
	
	public HashMap<String,Integer> getFullHashMap(String filepath){
		hashmap = new HashMap<String,Integer>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filepath));
			String str;
			while((str = reader.readLine()) != null){
				hashmap.put(str, 1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hashmap;
	}
	
	public void getFullHashMapKeys(HashMap<String,Integer> ha){
		Set<String> keys = ha.keySet();
		System.out.println("hashmap×Ü´óÐ¡£º" + keys.size());
	}
	
	public void getKeysAndTimes(){
		Set<Entry<String,Integer>> set = hashmap.entrySet();
		for(Entry<String,Integer> entry : set){
			if(entry.getValue() > 1)
			System.out.println("keys:" + entry.getKey() + " values:" + entry.getValue());
		}
	}
	
	public static void main(String[] args){
		HashMapTest hashMapTest = new HashMapTest();
		
		hashMapTest.hashmap = hashMapTest.getFullHashMap("D:\\targetFile\\randomFiles1.txt");
		hashMapTest.getFullHashMapKeys(hashMapTest.hashmap);
		hashMapTest.getKeysAndTimes();
	}
}
