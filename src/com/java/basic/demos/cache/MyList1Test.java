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
		//��ֹ��ѡ��̭�ڵ㣬�ڵ��е�ֵΪ��̭�ڵ��λ��
		MyList1 passList = new MyList1();
		
		//��ʼ����50��item��Ϊ1
		for(int i = 0;i < 50;i++)
		{
			Node node = new Node(1);
			list.add(node);
		}
		System.out.println("��ʼ����\n" + list.toString());
		System.out.println("==============================");
		
		for(int j = 1;j <= 300; j++){
			System.out.println("��" + j + "�Σ�");
			
			//item����age������һ���ڵ�
			for(int k = 0;k < list.getSize();k++){
				list.get(k).setData(list.get(k).getData()+1);
				if(list.get(k).getData() > 10)
				{
					passList.add(new Node(k));
				}
			}
			//�������λ�ò�����
			Random random = new Random();
			int index = random.nextInt(list.getSize() + 1);
			list.add(index, new Node(1));
			
			System.out.println("��ӽڵ�λ��:" + index);
			System.out.println("������Ϻ�����\n" + list.toString());
			
			//����������ֵ̭�Ľڵ�
			for(int k = 0;k < list.getSize();k++){
				if(list.get(k).getData() > 10)
				{
					passList.add(new Node(k));
				}
			}
			
			//��̭�ڵ�
			Integer passidx = null;
			if(passList.getSize() > 0){
				Random passran = new Random();
				passidx= passList.get(passran.nextInt(passList.getSize())).getData();
			}else if(list.getSize() > 100){
				passidx = 0;
			}
			
			if(passidx == null){
				System.out.println("����̭���ݣ�");
			}else{
				list.remove(passidx.intValue());
				System.out.println("��̭�ڵ�λ��:" + passidx);
			}
			
			System.out.println("��̭��Ϻ�����\n" + list.toString());
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
