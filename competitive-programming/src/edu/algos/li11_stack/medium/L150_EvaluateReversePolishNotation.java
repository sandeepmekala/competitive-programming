package edu.algos.li11_stack.medium;

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
		Stack<Integer> stack = new Stack<Integer>();	
		for(int i=0; i<tokens.length; i++){
			if(!tokens[i].equals("+") && !tokens[i].equals("*") && !tokens[i].equals("-") && !tokens[i].equals("/"))  { 
				stack.push(Integer.parseInt(tokens[i]));
			}else{
				int op2 = stack.pop();	
				int op1 = stack.pop();	
				if(tokens[i].equals("+")) stack.push(op1+op2);
				else if(tokens[i].equals("-")) stack.push(op1-op2);
				else if(tokens[i].equals("*")) stack.push(op1*op2);
				else stack.push(op1/op2);
				
			}
		}
		return stack.pop();
	}

}
