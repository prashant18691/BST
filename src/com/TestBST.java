package com;

public class TestBST {
	
	private Node root;
	
	
	public void addNode(int v){
	root = 	insertNode(root,v);
	}

	private Node insertNode(Node parent, int v) {
		
		if (parent == null) {
			parent = new Node(v);;
		} else {

			if (parent.getVal() >= v) {
				parent.left = insertNode(parent.getLeft(), v);
			} else {
				parent.right = insertNode(parent.getRight(), v);
			}
		}

		return parent;

	}

	public TestBST() {
		// TODO Auto-generated constructor stub
	}
	public void preorder(){
		preorder(root);
	}
	
	public void preorder(Node n){
		if(n!=null){
			System.out.println(n.getVal());
			preorder(n.getLeft());
			preorder(n.getRight());
		}
	}

	public static void main(String[] args) {

		TestBST bst = new TestBST();
		bst.addNode(5);
		bst.addNode(4);
		bst.addNode(6);
		bst.addNode(3);
		bst.addNode(8);
		bst.addNode(2);
		bst.addNode(7);
		
		bst.preorder();
		
	}

}


class Node{
	private int val;
	Node left,right;
	
	
	
	public int getVal() {
		return val;
	}



	public void setVal(int val) {
		this.val = val;
	}



	public Node getLeft() {
		return left;
	}



	public void setLeft(Node left) {
		this.left = left;
	}



	public Node getRight() {
		return right;
	}



	public void setRight(Node right) {
		this.right = right;
	}



	Node(int v){
		val=v;
		left=null;
		right=null;
	}
}
