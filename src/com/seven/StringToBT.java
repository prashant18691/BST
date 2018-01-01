package com.seven;

import java.util.Stack;

import com.six.Node;

public class StringToBT {
	
	public Node stringToBT(String str){
		if(str==null)
			return null;
		char[] strChr = str.toCharArray();
		Stack<Character> st = new Stack<>();
		for(int i=0;i<strChr.length;i++){
			if(strChr[i]=='(')
				st.push(strChr[i]);
			else{
				
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
