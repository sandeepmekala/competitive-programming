package  com.algos.core.li07_stack.revised;

import java.util.Stack;

public class L20_ValidParentheses {

	public static void main(String[] args) {
		L20_ValidParentheses obj = new L20_ValidParentheses();
		System.out.println(obj.isValid("[()]"));
	}

	// Problem: https://leetcode.com/problems/valid-parentheses/
	// Idea: Push open bracket to stack and compare top of the stack if you see close bracket.
	public boolean isValid(String s){
		Stack<Character> stack = new Stack<>();
		for(Character ch : s.toCharArray()){
			if(ch == '(' || ch == '{' || ch == '[' ){
				stack.push(ch);
			}else {
				if(stack.isEmpty())
					return false;
				if(!isMatching(stack.pop(), ch))
					return false;
			}
		}
		return stack.isEmpty();
	}

	private boolean isMatching(Character stackTop, Character input){
		if(stackTop == '(' && input == ')')
			return true;
		else if(stackTop == '{' && input == '}')
			return true;
		else if(stackTop == '[' && input == ']')
			return true;
		else
			return false;
	}
}
