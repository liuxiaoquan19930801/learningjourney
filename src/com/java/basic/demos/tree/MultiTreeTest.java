package com.java.basic.demos.tree;

import com.java.basic.datastructure.myList1.MyList1;
import com.java.basic.datastructure.node.Node;

public class MultiTreeTest {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node treeRootA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeD = new Node("D");
		Node nodeF = new Node("F");
		Node nodeH = new Node("H");
		Node nodeN = new Node("N");
		
		treeRootA.getMylist().add(nodeB).add(new Node("C")).add(nodeD);
		nodeB.getMylist().add(new Node("E")).add(nodeF).add(new Node("G"));
		nodeD.getMylist().add(nodeH).add(new Node("I")).add(new Node("J"));
		nodeF.getMylist().add(new Node("K")).add(new Node("L")).add(nodeN);
		nodeH.getMylist().add(new Node("O")).add(new Node("P")).add(new Node("Q"));
		nodeN.getMylist().add(new Node("R")).add(new Node("S")).add(new Node("T"));

		MultiTree mulTree1 = new MultiTree();
		String from = "G";
		MyList1 fromList = mulTree1.FindFromRootToDes(treeRootA, from);
		System.out.println(fromList.toString());
		
		
		MultiTree mulTree2 = new MultiTree();
		String to = "R";
		MyList1 toList = mulTree2.FindFromRootToDes(treeRootA, to);
		System.out.println(toList.toString());
		
	}

}
