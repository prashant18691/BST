package com.four;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeCloning {

	Node root;

	static Map<Node,Node> map = new HashMap<>();
	
	public static void main(String[] args) {

		BinaryTreeCloning t = new BinaryTreeCloning();				
		t.root = new Node(1);									
		t.root.left = new Node(2);	//2-3
		t.root.right = new Node(3);								
		t.root.left.left = new Node(4);//1-4								   
		t.root.left.right= new Node(5);
		t.root.right.left= new Node(6); 
		t.root.right.right= new Node(7);
		t.root.left.left.left = new Node(8);
		t.root.left.left.right = new Node(9); // 9-6
		t.root.right.right.left = new Node(10); //10-1
		t.root.right.right.right = new Node(11);

		t.root.left.random = t.root.right;
		t.root.left.left.right.random=t.root.right.left;
		t.root.right.right.left.random = t.root;
		t.root.random = t.root.left.left;
		
		t.cloneBT(t.root);
//		t.printInorder(t.root);
		t.printInorder(map.get(t.root));
	}
	
	void printInorder(Node n){
		if(n==null)
			return;

		printInorder(n.left);
		int random=n.random!=null?n.random.data:-1;
		System.out.println(n.data+" "+random);
		printInorder(n.right);
	}
	
	void cloneBT(Node n){
		if(n==null)
			return;
		Node copyNode = map.get(n);
		
		if(copyNode==null){
			copyNode = new Node(n.data);
		}
		
		if(n.left!=null)
		copyNode.left = new Node(n.left.data);
		if(n.right!=null)
		copyNode.right = new Node(n.right.data);
		if(n.random!=null)
		copyNode.random = new Node(n.random.data);
		map.put(n, copyNode);
		map.put(n.left, copyNode.left);
		map.put(n.right, copyNode.right);
		
		cloneBT(n.left);
		cloneBT(n.right);
	}

}

class Node{
	int data;
	Node left,right,random;
	
	public Node(int data) {
		super();
		this.data = data;
	}
	
	
}
