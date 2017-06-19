package com.java.basic.datastructure.myList1;

import com.java.basic.datastructure.node.Node;

public class MyList1 {

	int size = 0;
	Node headNode = null;
	Node tailNode = null;
	Node tmpNode = null;
	
	public MyList1(){
/*		this.headNode = new Node();
		this.headNode = new Node();
		System.out.println(this.headNode.getData());*/
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node getTmpNode() {
		return tmpNode;
	}

	public void setTmpNode(Node tmpNode) {
		this.tmpNode = tmpNode;
	}

	public MyList1 add(Node node){
		if(this.size == 0){
			this.headNode = node;
			this.tailNode = node;
			this.size += 1;
		}else{
			this.tmpNode = node;
			this.tailNode.setNextNode(this.tmpNode);
			this.tailNode = this.tmpNode;
			this.size += 1;
		}		
		return this;
	}
	
	public MyList1 add(int i,Node node){
		if(i > this.size) return this;
		if(this.size == 0){
			this.headNode = node;
			this.tailNode = node;
			this.size += 1;
		}else{
			this.tmpNode = this.headNode;
			if(i == 0){
				node.setNextNode(this.tmpNode);
				this.headNode = node;
				this.tmpNode = this.headNode;
			}else{
				for(int k = 0;k < i-1;k++){
					this.tmpNode = this.tmpNode.getNextNode();
				}
				node.setNextNode(this.tmpNode.getNextNode());
				this.tmpNode.setNextNode(node);
			}
			this.size += 1;
		}		
		return this;
	}

	public MyList1 remove(int i){
		if(i > this.size-1) return this;
		this.tmpNode = this.headNode;
		for(int k = 1;k < i;k++){
			this.tmpNode = this.tmpNode.getNextNode();
		}
		if(this.tmpNode == this.headNode)
		{
			if(i == 0){
				this.headNode = this.tmpNode.getNextNode();
				this.tmpNode.setNextNode(null);
				this.tmpNode = this.headNode;
			}else{
				this.headNode.setNextNode(this.tmpNode.getNextNode().getNextNode());
			}
		}else{
			this.tmpNode.setNextNode(this.tmpNode.getNextNode().getNextNode());

		}
		this.size -= 1;
		return this;
	}
	
	public Node get(int index){
		if(index > this.size-1){
			System.out.println("out of bound!");
		}
		else{
			this.tmpNode = this.headNode;
			if(index == 0){}
			else{
				for(int i = 0;i < index;i++){
						this.tmpNode = this.tmpNode.getNextNode();
				}
			}
		}
		return this.tmpNode;
	}
	
	public String toString(){
		if(this.size ==0) return "list is null";
		else {
			StringBuffer resultString = new StringBuffer();
			this.tmpNode = this.headNode;
			while(this.tmpNode != null){
				resultString.append(this.tmpNode.getData()).append(" ");
				this.tmpNode = this.tmpNode.getNextNode();
			}
			return resultString.toString();
		}
	}
	
	public String toString2(){
		if(this.size ==0) return "list is null";
		else {
			StringBuffer resultString = new StringBuffer();
			this.tmpNode = this.headNode;
			while(this.tmpNode != null){
				resultString.append(this.tmpNode.getString()).append(" ");
				this.tmpNode = this.tmpNode.getNextNode();
			}
			return resultString.toString();
		}
	}
}
