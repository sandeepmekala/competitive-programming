package  com.algos.li11_stack;

import java.util.Stack;

public class L20_ValidParentheses {

	public static void main(String[] args) {
		L20_ValidParentheses obj = new L20_ValidParentheses();
		System.out.println(obj.isValid("[()]"));
	}

	// Problem: https://leetcode.com/problems/valid-parentheses/
	// Idea: Push open bracket to stack and compare top of the stack if you see close bracket.
	public boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ){
				stack.push(s.charAt(i));
			}else {
				if(stack.isEmpty())
					return false;
				if(!matching(stack.pop(), s.charAt(i)))
					return false;
			}
		}
		return stack.isEmpty();
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
