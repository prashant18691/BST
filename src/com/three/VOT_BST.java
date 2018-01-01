package com.three;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class VOT_BST {
	Node root;
	MinMax val = new MinMax();
	
	void firstTraversal(){
		findMinMaxHD(root,val,val,0);
		
//		System.out.println(val.min+" "+val.max);
		
		for(int i =val.min;i<=val.max;i++){
			printVOT1(root,i,0);
			System.out.println();
		}
		
	}
	

	private void printVOT1(Node node, int line_no, int hd) {
		if(node==null)
			return;
		if(line_no==hd)
			System.out.print(node.data+" ");
		
		printVOT1(node.left, line_no, hd-1);
		printVOT1(node.right, line_no, hd+1);
		
	}


	private void findMinMaxHD(Node node, MinMax min, MinMax max, int hd) {

		if(node==null)
			return;
		
		if(min.min>hd)
			min.min=hd;
		else if(max.max<hd)
			max.max=hd;
		
		findMinMaxHD(node.left,min,max,hd-1);
		findMinMaxHD(node.right,min,max,hd+1);
	}
	
	void secondTraversal(){
		
		if(root==null)
			return;
		
		TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<>();
		
		getVOT(root,map,0);
		
		for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
			for(Integer n : entry.getValue()){
				System.out.print(n+" ");
			}
			System.out.println();
		}
		
		
	}
	


	private void getVOT(Node node, TreeMap<Integer, ArrayList<Integer>> map, int hd) {
		if(node==null)
			return;
		ArrayList<Integer> l = map.get(hd);
		if(l==null){
			map.put(hd, l=new ArrayList<>());
		}
		l.add(node.data);
		
		getVOT(node.left, map, hd-1);
		getVOT(node.right, map, hd+1);
		
	}
	
	
	void thirdTraversal(){
		if(root==null)
			return;
		
		
		TreeMap<Integer,List<Integer>> map = new TreeMap<>(); 

		Map<Node,Integer> que = new LinkedHashMap<>();
		
		int hd=0;
		que.put(root,hd);
		
		while(!que.isEmpty()){
			
			Entry<Node, Integer> entry=(Entry<Node, Integer>)que.entrySet().iterator().next();
			Node n = entry.getKey();
			hd = entry.getValue();
			que.remove(n);
			
			List<Integer> list = map.get(hd);
			
			if(list==null)
				map.put(hd, list = new ArrayList<>());
			
			list.add(n.data);
			
			if(n.left!=null)
				que.put(n.left, hd-1);
			if(n.right!=null)
				que.put(n.right, hd+1);
			
		}
		
		
		for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
			for(Integer n : entry.getValue()){
				System.out.print(n+" ");
			}
			System.out.println();
		}
		
	}


	public static void main(String[] args) {
		VOT_BST tree = new VOT_BST();
		  
        /* Let us construct the tree shown in above diagram */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.root.right.right.right = new Node(9);
        tree.root.right.right.left = new Node(10);
        tree.root.right.right.left.right = new Node(11);
        tree.root.right.right.left.right.right = new Node(12);
        System.out.println("vertical order traversal is :");
        tree.secondTraversal();

	}

}

class MinMax{
	int min,max;
}

class Node{
	int data;
	Node left,right;
	
	public Node(int data){
		this.data=data;
		left=right=null;
	}
}
