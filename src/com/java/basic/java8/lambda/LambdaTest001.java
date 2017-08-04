package com.java.basic.java8.lambda;

public class LambdaTest001 {

    public static void main(String[] args){
        LambdaTest001 lambdaTest001 = new LambdaTest001();

        MathOperation mathOperation = (int a,int b) -> a+b;
        MathOperation minus = (int a,int b) -> a-b;
        System.out.println("10 + 5 = " + mathOperation.operation(10,5));
        System.out.println("10 - 5 = " + lambdaTest001.operate(10,5,minus));
    }


    private int operate(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }

}
