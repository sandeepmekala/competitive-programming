package edu.algos.li12_stack;

import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		System.out.println(infixToPostfixWithoutParentheses("A+B*C-D*E"));
		System.out.println(infixToPostfixWithParentheses("((A+B)*C-D)*E"));
		
	}	
	public static String infixToPostfixWithoutParentheses(String exp){
		String res = "";
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<exp.length(); i++){
			if(IsOperand(exp.charAt(i))){
				res = res + exp.charAt(i);
			}else if(IsOperator(exp.charAt(i))){
				while(!stack.isEmpty() && hasHigherPrecedence(stack.peek(), exp.charAt(i))){
					res = res + stack.pop();
				}
				stack.push(exp.charAt(i));
			}
		}
		while(!stack.isEmpty()){
			res = res + stack.pop();
		}
		return res;
	}
	public static String infixToPostfixWithParentheses(String exp){
		String res = "";
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<exp.length(); i++){
			if(IsOperand(exp.charAt(i))){
				res = res + exp.charAt(i);
			}else if(IsOperator(exp.charAt(i))){
				while(!stack.isEmpty() && stack.peek() != '(' && hasHigherPrecedence(stack.peek(), exp.charAt(i))){
					res = res + stack.pop();
				}
				stack.push(exp.charAt(i));
			}else if(exp.charAt(i) == '('){
				stack.push(exp.charAt(i));
			}else  if(exp.charAt(i) == ')'){
				while(!stack.isEmpty() && stack.peek() != '('){
					res = res + stack.pop();
				}
				stack.pop();
			}
		}
		while(!stack.isEmpty()){
			res = res + stack.pop();
		}
		return res;
	}
	private static boolean IsOperand(char C) 
	{
		if(C >= '0' && C <= '9') return true;
		if(C >= 'a' && C <= 'z') return true;
		if(C >= 'A' && C <= 'Z') return true;
		return false;
	}
	private static boolean IsOperator(char C)
	{
		if(C == '+' || C == '-' || C == '*' || C == '/' || C== '$')
			return true;

		return false;
	}
	private static boolean IsRightAssociative(char op)
	{
		if(op == '$') return true;
		return false;
	}
	private static int getOperatorWeight(char op)
	{
		int weight = -1; 
		switch(op)
		{
		case '+':
		case '-':
			weight = 1;
			break;
		case '*':
		case '/':
			weight = 2;
			break;
		case '$':
			weight = 3;
			break;
		}
		return weight;
	}

	private static boolean hasHigherPrecedence(char op1, char op2)
	{
		int op1Weight = getOperatorWeight(op1);
		int op2Weight = getOperatorWeight(op2);

		// If operators have equal precedence, return true if they are left associative. 
		// return false, if right associative. 
		// if operator is left-associative, left one should be given priority. 
		if(op1Weight == op2Weight)
		{
			if(IsRightAssociative(op1)) return false;
			else return true;
		}
		return op1Weight > op2Weight ?  true: false;
	}
}
