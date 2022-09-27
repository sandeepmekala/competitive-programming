package edu.algos.li12.stack;

import java.util.Stack;

public class CheckForBalancedMParentheses {

	public static void main(String[] args) {
		CheckForBalancedMParentheses obj = new CheckForBalancedMParentheses();
		System.out.println(obj.checkForBalancedMParentheses("[()]"));
	}
	public boolean checkForBalancedMParentheses(String exp){
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
	private boolean matching(Character stacktop, Character input){
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
