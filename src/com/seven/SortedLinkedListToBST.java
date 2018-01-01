package com.seven;



public class SortedLinkedListToBST {
	
	LinkedList head;
	
	public Node createBST(){
		
		int n = getNodesCount(head);
		
		return builtBST(n);
	}

	private Node builtBST(int n) {

		if(n<=0)
			return null;
		
		Node left = builtBST(n/2);
		
		Node root = new Node(head.data);
		
		root.left=left;
		
		head=head.next;
		
		Node right = builtBST(n-n/2-1);
		root.right=right;
		
		return root;
	}

	private int getNodesCount(LinkedList n) {
		int count = 0;
		while(n!=null){
			count++;
			n=n.next;
		}
		return count;
	}
	
	void push(int data){
		LinkedList n = new LinkedList(data);
		n.next=head;
		head=n;
	}

	public static void main(String[] args) {
		
		SortedLinkedListToBST t = new SortedLinkedListToBST();
		t.push(7);
		t.push(6);
		t.push(5);
		t.push(4);
		t.push(3);
		t.push(2);
		t.push(1);
		
		Node n =t.createBST();
		
		printBST(n);

		
	}

	private static void printBST(Node n) {

		if(n==null)return;
		
		System.out.print(n.data+" ");
		printBST(n.left);
		printBST(n.right);
	}

}
