package com.one;

public class TestConnectNodes {
	
	Node root;
	
	public void conneNodes(Node root){
		root.nextRight=null;
		connectNodes(root);			
	}
	
	public void connectNodes(Node node){
		if(node==null)
			return;
		
		if(node.left!=null)
			node.left.nextRight=node.right;
		
		if(node.right!=null){
			node.right.nextRight=(node.nextRight!=null)?node.nextRight.left:null;
		}
		connectNodes(node.left);
		connectNodes(node.right);
	
		
	}
	

	public void printNodes(Node node){
		if(node!=null){
			Integer data = (node.nextRight!=null)?node.nextRight.data:null;
			System.out.println("Node data :: "+node.data+" Next Right Data :: "+data);
			printNodes(node.left);
			printNodes(node.right);
		}
	}
	
	void connectNodesRecurr(Node n){
		
		if(n==null)
			return;
		
		if(n.nextRight!=null)
			connectNodesRecurr(n.nextRight);
		
		if(n.left!=null){
			if(n.right!=null){
				n.left.nextRight=n.right;
				n.right.nextRight=getNextRight(n);
			}
			else
				n.left.nextRight = getNextRight(n);
			
			connectNodesRecurr(n.left);
		}
		else if(n.right!=null){
			n.right.nextRight=getNextRight(n);
			
			connectNodesRecurr(n.right);
		}
		else
			connectNodesRecurr(n.nextRight);
		
			
		
	}
	

	private Node getNextRight(Node n) {
		Node temp = n.nextRight;
		
		while(temp!=null){
			if(temp.left!=null)
				return temp.left;
			if(temp.right!=null)
				return temp.right;
			temp=temp.nextRight;
		}
		return null;
		
	}

	public static void main(String[] args) {

		TestConnectNodes t = new TestConnectNodes();				
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
		
//		t.conneNodes(t.root);
		
	//	t.printNodes(t.root);
		
		//t.usingBFS();
		
		t.connectNodesRecurr(t.root);
		t.printNodes(t.root);
		
	}

}

class Node{
	int data;
	Node left,right,nextRight;
	public Node(int data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
		this.nextRight = null;
	}
	
	
	
	
}
