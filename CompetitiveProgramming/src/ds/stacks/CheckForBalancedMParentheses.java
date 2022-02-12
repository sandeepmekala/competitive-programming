package ds.stacks;

import java.util.Stack;

public class CheckForBalancedMParentheses {

	public static void main(String[] args) {
		System.out.println(checkForBalancedMParentheses("[(})]"));
	}
	public static boolean checkForBalancedMParentheses(String exp){
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<exp.length(); i++){
			if(exp.charAt(i) == '(' || exp.charAt(i) == '{' || exp.charAt(i) == '[' ){
				stack.push(exp.charAt(i));
			}else if(exp.charAt(i) == ')' || exp.charAt(i) == '}' || exp.charAt(i) == ']' ){
				if(stack.isEmpty() || matching(exp.charAt(i), stack.pop())){
					return false;
				}
			}
		}
		return stack.isEmpty()? true:false;
	}
	private static boolean matching(Character original, Character stachTop){
		if(original == '(' && stachTop == ')')
			return true;
		else if(original == '{' && stachTop == '}')
			return true;
		else if(original == '[' && stachTop == ']')
			return true;
		else
			return false;
		
	}
}
