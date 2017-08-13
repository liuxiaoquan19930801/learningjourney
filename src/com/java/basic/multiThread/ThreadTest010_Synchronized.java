package com.java.basic.multiThread;

public class ThreadTest010_Synchronized {
    
    public synchronized void Method1(){
        System.out.println("Method1");
        while(true){
            System.out.println(1);
            try {
                Thread.sleep(100000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void Method2(){
        System.out.println("Method2");
    }
    
    public static void main(String[] args){
        ThreadTest010_Synchronized threadTest010_synchronized = new ThreadTest010_Synchronized();
        Method method1 = new Method(threadTest010_synchronized,"1");
        Method method2 = new Method(threadTest010_synchronized,"1");
        new Thread(method1).start();
        new Thread(method2).start();
        Class a = Method.class ;
    }
}

class Method implements Runnable{
    private ThreadTest010_Synchronized threadTest010_synchronized;
    private String flag = null;
    
    public Method(ThreadTest010_Synchronized a,String b){
        this.threadTest010_synchronized = a;
        this.flag = b;
    }
    
    @Override
    public void run() {
        if (flag.equals("1")){
            this.threadTest010_synchronized.Method1();
        }else{
            this.threadTest010_synchronized.Method2();
        }
    }
}
