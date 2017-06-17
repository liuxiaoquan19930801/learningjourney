package com.java.basic.demos.tree;

import com.java.basic.datastructure.myList1.MyList1;
import com.java.basic.datastructure.node.Node;

public class MultiTree {

	private String from;
	private String to;
	//从根节点到达目的节点的路径位置记录在MyList中
	private MyList1 fromPath = new MyList1();
	private MyList1 toPath = new MyList1();
	private boolean flag = false;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public MyList1 getFromPath() {
		return fromPath;
	}
	public void setFromPath(MyList1 fromPath) {
		this.fromPath = fromPath;
	}
	public MyList1 getToPath() {
		return toPath;
	}
	public void setToPath(MyList1 toPath) {
		this.toPath = toPath;
	}
	
	public MyList1 FindFromRootToDes(Node fromNode,String des){

		if(fromNode.getString().equals(des)) {
			flag = true;
		}
		if(flag == true){
			System.out.println(fromNode.getString());
		}
		else{
				for(int i=0;i<fromNode.getMylist().getSize();i++){
					FindFromRootToDes(fromNode.getMylist().get(i),des);
					if(flag == true){
						System.out.println(fromNode.getString());
						this.fromPath.add(0,new Node(i));
						return this.fromPath;}
			}
		}
		
		return this.fromPath;
	}
	
	
/*	public MyList1 FindFromRootToDes(Node fromNode,String des){

		if(fromNode.getString().equals(des)) {
			flag = true;
		}
		if(flag == true){
			System.out.println(fromNode.getString());
			this.fromPath.add(0, fromNode);
			return this.fromPath;
		}
		else{
				for(int i=0;i<fromNode.getMylist().getSize();i++){
					FindFromRootToDes(fromNode.getMylist().get(i),des);
					if(flag == true){
						System.out.println(fromNode.getString());
						this.fromPath.add(0, fromNode);
						return this.fromPath;}
			}
		}
		
		return this.fromPath;
	}*/
	
}
