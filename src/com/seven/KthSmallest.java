package com.seven;

public class KthSmallest {
	
	Node root;
	
	public Integer findKthSmallest(Node root,int k){
		if(root==null) return null;
		
		Node curr = root; Node pre;
		int count = 0;Integer kSmallest = null;
		
		while(curr!=null){
			if(curr.left==null){
				count++;
				if(count==k){
					kSmallest=curr.data;
					break;
				}
				curr=curr.right;
			}
			else{
				pre=curr.left;
				
				while(pre.right!=null && pre.right!=curr)
					pre=pre.right;
				
				if(pre.right==null){
					pre.right=curr; // creating links to successor
					curr=curr.left;
				}
				else{
					pre.right=null; // reverting changes
					count++;
					if(count==k){
						kSmallest=curr.data;
						break;
					}
					curr=curr.right;
						
				}
			}
		}
		
		
		return kSmallest;
	}

	public static void main(String[] args) {

		 KthSmallest tree = new KthSmallest();
	        tree.root = new Node(20);
	        tree.root.left = new Node(8);
	        tree.root.right = new Node(22);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(12);
	        tree.root.left.right.left = new Node(10);
	        tree.root.left.right.right = new Node(14);
	        
	      System.out.println(tree.findKthSmallest(tree.root, 5));
	}

}
