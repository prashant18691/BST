package com.seven;

import com.six.Node;

public class SortedArrTOBST {
	
	public Node convert(int[] arr,int l,int r){
		Node parent =null;
		if(l<=r){
			int mid=(l+r)/2;
			parent = new Node(arr[mid]);
			Node left = convert(arr, l, mid-1);
			Node right = convert(arr, mid+1, r);
			parent.setLeft(left);
			parent.setRight(right);
		}
		return parent;
		
	}

	public static void main(String[] args) {

		SortedArrTOBST t = new SortedArrTOBST();
		int[] arr = {1, 2, 3, 4};
		Node root=t.convert(arr, 0, arr.length-1);
		
		printNode(root);
	}

	private static void printNode(Node n) {

		if(n==null)
			return;
		printNode(n.getLeft());
		System.out.print(n.getData()+" ");
		printNode(n.getRight());
	}

}
