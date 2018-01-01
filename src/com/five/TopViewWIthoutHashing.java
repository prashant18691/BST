package com.five;

public class TopViewWIthoutHashing {

	Node root;

	public static void main(String[] args) {

		TopViewWIthoutHashing tree = new TopViewWIthoutHashing();
		tree.root = new Node(3);
		tree.root.left = new Node(5);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(4);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.left.left.right = new Node(9);
		tree.root.right.right.left = new Node(8);
		DoublyLinkedList list = new DoublyLinkedList(Integer.MAX_VALUE, Integer.MAX_VALUE);

		tree.getTopView(tree.root, list, 0);

		DoublyLinkedList head = list;

		while (head.prev != null)
			head = head.prev;

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	private void getTopView(Node node, DoublyLinkedList list, int hd) {

		if (node == null)
			return;

		if(hd<list.hd){
		list.data = node.data;
		list.hd = hd;
		}

		// left child
		if (node.left != null) {
			if (list.prev != null) {
				getTopView(node.left, list.prev, hd - 1);
			} else {
				DoublyLinkedList ltmp = new DoublyLinkedList(Integer.MAX_VALUE, Integer.MAX_VALUE);
				ltmp.next = list;
				list.prev = ltmp;
				getTopView(node.left, ltmp, hd - 1);
			}
		}

		// right child
		if (node.right != null) {
			if (list.next != null) {
				getTopView(node.right, list.next, hd + 1);
			} else {
				DoublyLinkedList ltmp = new DoublyLinkedList(Integer.MAX_VALUE, Integer.MAX_VALUE);
				ltmp.prev = list;
				list.next = ltmp;
				getTopView(node.right, ltmp, hd + 1);
			}
		}

	}

}

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		super();
		this.data = data;
	}

}

class DoublyLinkedList {
	DoublyLinkedList prev, next;
	int data, hd;

	public DoublyLinkedList(int data, int hd) {
		super();
		this.data = data;
		this.hd = hd;
	}

}
