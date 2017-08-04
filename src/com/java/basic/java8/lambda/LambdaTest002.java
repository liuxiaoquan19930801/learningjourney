package com.java.basic.java8.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest002 {

    @Test
    public void Test01(){
        Runnable r1 = () -> System.out.println("Runnable");
        r1.run();
    }

    @Test
    public void Test02(){
        Consumer<String> con = x -> System.out.println(x);
        con.accept("hello world");
    }

    @Test
    public void Test03(){
        Comparator<Integer>  com = (x,y) ->
        {
         System.out.println("Lambda输出：");
         return Integer.compare(x,y);
        };
        System.out.println(com.compare(20,30));
    }

    @Test
    public void Test04(){
        Comparator<String> com2 = (String x,String y) -> String.CASE_INSENSITIVE_ORDER.compare(x,y);
        System.out.println(com2.compare("xyz","bcd"));
    }

}
