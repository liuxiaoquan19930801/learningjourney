package com.java.basic.java8.lambda;

public class LambdaTest001 {

    public static void main(String[] args){
        LambdaTest001 lambdaTest001 = new LambdaTest001();

        MathOperation addition = (int a,int b) -> a+b;
        MathOperation minus = (int a,int b) -> a-b;
        System.out.println("10 + 5 = " + lambdaTest001.operate(10,5,addition));
        System.out.println("10 - 5 = " + lambdaTest001.operate(10,5,minus));
    }

    public int addition(int a,int b){
        return a+b;
    }
    public int minus(int a,int b){
        return a-b;
    }


    interface MathOperation {
        int operation(int a,int b);
    }

    private int operate(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }

}
