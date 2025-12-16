
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Stack_BalancedParenthesesWithStringsUniquePairing {
    public static void main(String[] args) {
		Stack_BalancedParenthesesWithStringsUniquePairing obj = new Stack_BalancedParenthesesWithStringsUniquePairing();
		System.out.println(obj.isValid("[()]"));
		System.out.println(obj.isValid("[(())]"));
	}

	// Problem: https://leetcode.com/discuss/interview-question/5011090/Google-or-Onsite-or-Balanced-Parentheses-with-Strings-(Unique-Pairing)
	// Idea: Push open bracket to stack and compare top of the stack if you see close bracket.
	public boolean isValid(String s){
		HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Set<Character> vis = new HashSet<>();
		Stack<Character> stack = new Stack<>();
		for(Character ch : s.toCharArray()){
			if(map.containsKey(ch) ){		// opening bracket
                if(vis.contains(ch))
                    return false;
                vis.add(ch);
				stack.push(ch);
			}else {							// closing bracket
				if(stack.isEmpty() ||  !map.get(stack.peek()).equals(ch))
					return false;
				stack.pop();
                vis.remove(map.get(ch));
			}
		}
		return stack.isEmpty();
	}
}
