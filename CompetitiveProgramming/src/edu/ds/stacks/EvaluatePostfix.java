package edu.ds.stacks;

import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class EvaluatePostfix {

	public static void main(String[] args) throws ScriptException {
		
		System.out.println(evaluatePostfix("23*54*+9-"));
	}
	public static int evaluatePostfix(String exp) throws ScriptException{
		Stack<Integer> stack = new Stack<Integer>();	
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
		for(int i=0; i<exp.length(); i++){
			if(!(exp.charAt(i) == '+' || exp.charAt(i) == '*' || exp.charAt(i) == '-' || exp.charAt(i) == '/' || exp.charAt(i) == '^')){
				stack.push(Integer.parseInt(exp.charAt(i)+""));
			}else{
				int op2 = stack.pop();	//evalutatePrefix is also similar, we have traverse from right to left of the string
				int op1 = stack.pop();	//For evalutatePrefix, we have change the order if operands, first poped one is op1 and second poped one will be op2
				String subExp = op1+" "+exp.charAt(i)+" "+op2;
				int res = (int) engine.eval(subExp);
				stack.push(res);
			}
		}
		return stack.pop();
	}
}
