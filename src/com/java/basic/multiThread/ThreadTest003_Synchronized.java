package com.java.basic.multiThread;

public class ThreadTest003_Synchronized implements Runnable{

	private Foo foo = new Foo();
	
	public int fix(int y){
		return foo.fix(y);
	}
	
	/*此方法若不加synchronized关键字修饰， ta\tb线程则随意调用该方法，
	 * 导致每次结果都可能不同.
	 * 修饰之后，保证了同步块代码每次只有一个进程在访问。
	 * 多次执行的结果都是一样的。
	 */
	@Override
	public synchronized void run(){
		for(int i=0;i<3;i++){
			this.fix(i);
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				System.out.println(e);
			}
			System.out.println(Thread.currentThread().getName() + "当前foo对象的x值："
					+ this.foo.getX());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest003_Synchronized r = new ThreadTest003_Synchronized();
		Thread ta = new Thread(r,"Thread-A");
		Thread tb = new Thread(r,"Thread-B");
		
		ta.start();
		tb.start();
	}

}

//一个java文件可以有多个class类，但只允许有一个public class
class Foo{
	private int x = 100;
	
	public int getX(){
		return x;
	}
	
	public int fix(int y){
		x = x-y;
		return x;
	}
}