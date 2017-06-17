package com.java.basic.datastructure.node;

import com.java.basic.datastructure.myList1.MyList1;

public class Node {

	private int data;
	private String string;
	private Node nextNode = null;
	private MyList1 mylist= new MyList1();
	
	public Node(){

	}
	
	public Node(String string){
		this.string = string;
	}
	
	public Node(int i){
		this.data = i;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	public MyList1 getMylist() {
		return mylist;
	}
	public void setMylist(MyList1 mylist) {
		this.mylist = mylist;
	}
}
