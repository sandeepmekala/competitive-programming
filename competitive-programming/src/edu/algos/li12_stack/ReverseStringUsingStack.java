package edu.algos.li12_stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStringUsingStack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter String to reverse:");
		StringBuilder sb = new StringBuilder(sc.nextLine());
		System.out.println(reverseStringUsingStack(sb));
		
	}
	public static String reverseStringUsingStack(StringBuilder sb){
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<sb.length(); i++){
			stack.push(sb.charAt(i));
		}
		for(int i=0; i<sb.length(); i++){
			Character ch = stack.pop();
			sb.setCharAt(i, ch);
		}
		
		return sb.toString();
	}

}
