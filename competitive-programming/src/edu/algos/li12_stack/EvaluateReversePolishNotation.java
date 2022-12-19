package edu.algos.li12_stack;

import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) throws ScriptException {
		EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
		
		System.out.println(obj.evalRPN(new String[] {"2","1","+","3","*"}));
	}
	
	// evalutatePrefix is also similar, we have traverse from right to left of the string
	// for evalutatePrefix, we have change the order if operands, first poped one is op1 and second poped one will be op2
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();	
		
		for(int i=0; i<tokens.length; i++){
			if(!tokens[i].equals("+") && !tokens[i].equals("*") && !tokens[i].equals("-") && !tokens[i].equals("/"))  { 
				stack.push(Integer.parseInt(tokens[i]));
			}else{
				int op2 = stack.pop();	
				int op1 = stack.pop();	
				int res = eval(tokens[i], op1, op2);
				stack.push(res);
			}
		}
		return stack.pop();
	}
	
	private int eval(String operator, int op1, int op2) {
		if(operator.equals("+")) {
			return op1+op2;
		}else if(operator.equals("-")) {
			return op1-op2;
		}else if(operator.equals("*")) {
			return op1*op2;
		}else {
			return op1/op2;
		}
	}
}
