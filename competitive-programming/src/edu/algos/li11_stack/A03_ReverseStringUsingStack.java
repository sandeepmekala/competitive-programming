package edu.algos.li11_stack;

import java.util.Scanner;
import java.util.Stack;

public class A03_ReverseStringUsingStack {

	public static void main(String[] args) {
		A03_ReverseStringUsingStack obj = new A03_ReverseStringUsingStack();

		String str = "google";
		System.out.println(obj.reverseStringUsingStack(str));
		
	}

	public String reverseStringUsingStack(String s){
		Stack<Character> stack = new Stack<Character>();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<s.length(); i++){
			stack.push(s.charAt(i));
		}

		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}

}
