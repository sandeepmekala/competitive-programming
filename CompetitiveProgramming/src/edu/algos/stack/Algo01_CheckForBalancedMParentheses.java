package edu.algos.stack;

import java.util.Stack;

public class Algo01_CheckForBalancedMParentheses {

	public static void main(String[] args) {
		System.out.println(checkForBalancedMParentheses("[(})]"));
	}
	public static boolean checkForBalancedMParentheses(String exp){
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<exp.length(); i++){
			if(exp.charAt(i) == '(' || exp.charAt(i) == '{' || exp.charAt(i) == '[' ){
				stack.push(exp.charAt(i));
			}else if(exp.charAt(i) == ')' || exp.charAt(i) == '}' || exp.charAt(i) == ']' ){
				if(stack.isEmpty() || !matching(stack.pop(), exp.charAt(i))){
					return false;
				}
			}
		}
		return stack.isEmpty()? true:false;
	}
	private static boolean matching(Character stacktop, Character input){
		if(stacktop == '(' && input == ')')
			return true;
		else if(stacktop == '{' && input == '}')
			return true;
		else if(stacktop == '[' && input == ']')
			return true;
		else
			return false;
		
	}
}
