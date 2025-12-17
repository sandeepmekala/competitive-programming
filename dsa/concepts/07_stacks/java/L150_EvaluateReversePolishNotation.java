
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import javax.script.ScriptException;

public class L150_EvaluateReversePolishNotation {

	public static void main(String[] args) throws ScriptException {
		L150_EvaluateReversePolishNotation obj = new L150_EvaluateReversePolishNotation();

		System.out.println(obj.evalRPN(new String[] {"2","1","+","3","*"}));
	}

	// Problem: https://leetcode.com/problems/evaluate-reverse-polish-notation/
	// Idea: Evaluate the exp in left to right order. Push the nums to stack.
	// EvalutatePrefix is also similar, we have to traverse from right to left of the string
	// For EvalutatePrefix, we have to change the order of operands, first poped one is op1 and second poped one will be op2
	public int evalRPN(String[] tokens) {
		Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

		Stack<Integer> stack = new Stack<>();
		for(String ch: tokens){
			if(!operators.contains(ch)) {
				stack.push(Integer.parseInt(ch));
			}else{
				int op2 = stack.pop();
				int op1 = stack.pop();
				if(ch.equals("+")) stack.push(op1+op2);
				else if(ch.equals("-")) stack.push(op1-op2);
				else if(ch.equals("*")) stack.push(op1*op2);
				else stack.push(op1/op2);
			}
		}
		return stack.pop();
	}

}
