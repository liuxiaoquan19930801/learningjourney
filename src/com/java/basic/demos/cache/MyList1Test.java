package com.java.basic.demos.cache;

import java.util.Random;

import com.java.basic.datastructure.myList1.MyList1;
import com.java.basic.datastructure.node.Node;

public class MyList1Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyList1 list = new MyList1();
		//防止待选淘汰节点，节点中的值为淘汰节点的位置
		MyList1 passList = new MyList1();
		
		//初始化，50个item均为1
		for(int i = 0;i < 50;i++)
		{
			Node node = new Node(1);
			list.add(node);
		}
		System.out.println("初始化：\n" + list.toString());
		System.out.println("==============================");
		
		for(int j = 1;j <= 300; j++){
			System.out.println("第" + j + "次：");
			
			//item增加age，插入一个节点
			for(int k = 0;k < list.getSize();k++){
				list.get(k).setData(list.get(k).getData()+1);
				if(list.get(k).getData() > 10)
				{
					passList.add(new Node(k));
				}
			}
			//产生随机位置并插入
			Random random = new Random();
			int index = random.nextInt(list.getSize() + 1);
			list.add(index, new Node(1));
			
			System.out.println("添加节点位置:" + index);
			System.out.println("插入完毕后链表：\n" + list.toString());
			
			//搜索可以淘汰值的节点
			for(int k = 0;k < list.getSize();k++){
				if(list.get(k).getData() > 10)
				{
					passList.add(new Node(k));
				}
			}
			
			//淘汰节点
			Integer passidx = null;
			if(passList.getSize() > 0){
				Random passran = new Random();
				passidx= passList.get(passran.nextInt(passList.getSize())).getData();
			}else if(list.getSize() > 100){
				passidx = 0;
			}
			
			if(passidx == null){
				System.out.println("无淘汰数据！");
			}else{
				list.remove(passidx.intValue());
				System.out.println("淘汰节点位置:" + passidx);
			}
			
			System.out.println("淘汰完毕后链表：\n" + list.toString());
			System.out.println("==============================");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
