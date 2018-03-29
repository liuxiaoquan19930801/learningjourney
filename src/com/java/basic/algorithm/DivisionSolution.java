package com.java.basic.algorithm;

public class DivisionSolution {
    
    public static void main(String[] args) {
    
        System.out.println(DivisionSolution.divide(3040, -59));
    }
    
    public static int divide(int divident, int divisor) {
        
        boolean resultGreaterThanZero = true;
        
        if(divident < 0 && divisor > 0 || divident > 0 && divisor < 0){
            resultGreaterThanZero = false;
        }
        
        long d1 = divident;
        long d2 = divisor;
        int ret = 0;
        
        while (d1 >= d2) {
            long temp = d2;
            int cnt = 1;
            while (d1 >= temp) {
                d1 -= temp;
                ret += cnt;
                temp = temp << 1;
                cnt = cnt << 1;
            }
        }
        
        if (!resultGreaterThanZero) {
            ret *= -1;
        }
        
        return ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE ? 2147483647 : ret;
    }
}
