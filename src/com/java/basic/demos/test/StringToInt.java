package com.java.basic.demos.test;

import java.util.ArrayList;
import java.util.LinkedList;

public class StringToInt {
    public static void main(String[] args){
        String from = "1234";
        char[] fr = from.toCharArray();
        int to = 0;
        for(int i = 0;i < fr.length ;i++)
        {
                to = i < fr.length ? to * 10 + (fr[i] - 48) : to + (fr[i] - 48);
            LinkedList<String> s = new LinkedList<String>();
            System.out.println(to);
        }
    }
}
