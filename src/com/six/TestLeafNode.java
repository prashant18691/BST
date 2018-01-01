package com.six;

public class TestLeafNode {

	Node root;
	
	
	void getLeafNode(Node n){
		
		if(n==null)
			return;
		
		if(n.left==null && n.right==null)
			System.out.print(n.data+" ");
		
		getLeafNode(n.left);
		getLeafNode(n.right);
		
		
		
	}
	
	
	public static void main(String[] args) {

		TestLeafNode t = new TestLeafNode();				
		t.root = new Node(1);									
		t.root.left = new Node(2);							
		t.root.right = new Node(3);								
		t.root.left.left = new Node(4);								   
		t.root.left.right= new Node(5);
		t.root.right.left= new Node(6);
		t.root.right.right= new Node(7);
		t.root.left.left.left = new Node(8);
		t.root.left.left.right = new Node(9);
		t.root.right.right.left = new Node(10);
		t.root.right.right.right = new Node(11);
		
		t.getLeafNode(t.root);
	}

}
