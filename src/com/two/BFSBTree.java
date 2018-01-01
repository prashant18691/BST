package com.two;

import java.util.LinkedList;
import java.util.Queue;

public class BFSBTree {

	Node root;
	
	public static void main(String[] args) {
		BFSBTree tree = new BFSBTree();
		  tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(7);
	        tree.root.left.right = new Node(6);
	        tree.root.right.left = new Node(5);
	        tree.root.right.right = new Node(4);
		tree.printSpiralLOT();
	}
	
	void secondBFS(){
		if(root==null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(root);
		
		while(!queue.isEmpty()){
			
			Node n = queue.poll();
			System.out.print(n.data+" ");
			
			if(n.left!=null)
				queue.add(n.left);
			if(n.right!=null)
				queue.add(n.right);
			
					
		}
		
	}
	
	void printSpiralLOT(){
		int height = height(root);
		boolean flip = false;
		
		for(int i=1;i<=height;i++){
			printGivenSpiralLOT(root,i,flip);
			flip=!flip;
		}
		
	}
	
	
	   private void printGivenSpiralLOT(Node node, int level, boolean flip) {
		   
		   
		   if(node==null)
			   return;
		   
		   if(level==1){
			   System.out.print(node.data+" ");
		   }
		   else{
			   if(flip){
				   printGivenSpiralLOT(node.left, level-1, flip);
				   printGivenSpiralLOT(node.right, level-1, flip);
			   }else{
				   printGivenSpiralLOT(node.right, level-1, flip);
				   printGivenSpiralLOT(node.left, level-1, flip);
			   }
				   
		   }
	}

	/* function to print level order traversal of tree*/
    void printLevelOrder()
    {
    	int height = height(root);
    	
    	for(int i=1;i<=height;i++){
    		printGivenLevel(root, i);
    	}
    }
 
    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(Node node)
    {
    	if(node==null)
    		return 0;
    	
    	int lHeight = height(node.left);
    	int rHeight = height(node.right);
    	
    	if(lHeight>rHeight)
    		return lHeight+1;
    	else
    		return rHeight+1;
    	
    }
 
    /* Print nodes at the given level */
    void printGivenLevel (Node root ,int level)
    {
    	if(root==null)
    		return;
    	if(level==1)
    		System.out.print(root.data + " ");
    	else
    	{
    		System.out.println();
    		printGivenLevel(root.left, level-1);
    		printGivenLevel(root.right, level-1);
    	}
    }
     

}

class Node{
	int data;
	Node left,right;
	
	public Node(int data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
