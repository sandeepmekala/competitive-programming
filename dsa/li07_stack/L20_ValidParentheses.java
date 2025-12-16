package li07_stack;

import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

public class L20_ValidParentheses {

	public static void main(String[] args) {
		L20_ValidParentheses obj = new L20_ValidParentheses();
		System.out.println(obj.isValid("[()]"));
	}

	// Problem: https://leetcode.com/problems/valid-parentheses/
	// Idea: Push open bracket to stack and compare top of the stack if you see close bracket.
	public boolean isValid(String s){
		HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

		Stack<Character> stack = new Stack<>();
		for(Character ch : s.toCharArray()){
			if(map.containsKey(ch) ){		// opening bracket
				stack.push(ch);
			}else {							// closing bracket
				if(stack.isEmpty() ||  !map.get(stack.peek()).equals(ch))
					return false;
				stack.pop();
			}
		}

		return stack.isEmpty();
	}
}
