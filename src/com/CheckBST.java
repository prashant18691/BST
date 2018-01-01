package com;

public class CheckBST {

	BTNode root,prev;
	public static void main(String[] args) {
		
		CheckBST tree = new CheckBST();
        tree.root = new BTNode(4);									//	 4
        tree.root.left = new BTNode(2);							   //	/ \
        tree.root.right = new BTNode(5);						  //   2   5
        tree.root.left.left = new BTNode(1);					 //	  / \   \
        tree.root.left.right = new BTNode(3);					//	 1   3  
//		System.out.println(tree.isBST());
        tree.preoder(tree.root);
		
	}
		
	
	public void preoder(BTNode node){
		if(node!=null){
			System.out.println(node.val);
			preoder(node.left);
			preoder(node.right);
		}
	}
	
	
	 boolean isBST()  {
	        return isBSTUtil(root, Integer.MIN_VALUE,
	                               Integer.MAX_VALUE);
		 
		 
		/* prev=null;
		 return isBSTUtil(root);*/
				 
	    }
	 
	    /* Returns true if the given tree is a BST and its
	      values are >= min and <= max. */
	    boolean isBSTUtil(BTNode node, int min, int max)
	    {
	        /* an empty tree is BST */
	        if (node == null)
	            return true;
	 
	        /* false if this node violates the min/max constraints */
	        if (node.val < min || node.val > max)
	            return false;
	 
	        /* otherwise check the subtrees recursively
	        tightening the min/max constraints */
	        // Allow only distinct values
	        return (isBSTUtil(node.left, min, node.val-1) &&
	                isBSTUtil(node.right, node.val+1, max));
	    }
	    
	    
	    
	    boolean isBSTUtil(BTNode node){
	    	if(node!=null){
	    		if(!isBSTUtil(node.left)){
	    			return false;
	    		}

	    		if(prev!=null && node.val<=prev.val){
	    			return false;
	    		}
	    		System.out.println(node.val);
	    		prev=node;
	    		return isBSTUtil(node.right);
	    	}
	    	return true;
	    }

}

class BTNode{
	int val;
	BTNode left,right;
	
	public BTNode(int val) {
		super();
		this.val = val;
		this.left = null;
		this.right = null;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public BTNode getLeft() {
		return left;
	}
	public void setLeft(BTNode left) {
		this.left = left;
	}
	public BTNode getRight() {
		return right;
	}
	public void setRight(BTNode right) {
		this.right = right;
	}
	
	
}
