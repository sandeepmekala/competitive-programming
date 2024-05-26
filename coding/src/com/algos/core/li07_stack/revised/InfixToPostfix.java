package  com.algos.core.li07_stack.revised;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		InfixToPostfix obj = new InfixToPostfix();

		System.out.println(obj.infixToPostfix("A+B*C-D*E"));
		System.out.println(obj.infixToPostfixWithParentheses("((A+B)*C-D)*E"));
	}

	// Problems: 
	// https://leetcode.com/problems/basic-calculator/
	// https://leetcode.com/problems/basic-calculator-ii/
	// https://leetcode.com/problems/basic-calculator-iii/
	// Idea: convert exp to postfix and evaluate postfix exp using stack.
	public List<String> infixToPostfix(String s){
		Stack<Character> stack = new Stack<Character>();
		List<String> res = new ArrayList<String>();
		for(int i=0; i<s.length(); i++){
			char ch = s.charAt(i);
			if(IsOperand(ch)){
                String num = String.valueOf(ch);
                while(i+1<s.length() && IsOperand(s.charAt(i+1))) 	// handles contigueous nums
					num += s.charAt(++i);
                
				res.add(num);
			}else if(IsOperator(ch)){
				while(!stack.isEmpty() && hasHigherPrecedence(stack.peek(), ch)){
					res.add(String.valueOf(stack.pop()));
				}
				stack.push(ch);
			}
		}
		while(!stack.isEmpty()){
			res.add(String.valueOf(stack.pop()));
		}
		return res;
	}

	public List<String> infixToPostfixWithParentheses(String s){
		Stack<Character> stack = new Stack<Character>();
		List<String> res = new ArrayList<String>();
		for(int i=0; i<s.length(); i++){
			char ch = s.charAt(i);
			if(IsOperand(ch)){
                String num = String.valueOf(ch);
                while(i+1<s.length() && IsOperand(s.charAt(i+1))) 
					num += s.charAt(++i);
                
				res.add(num);
			}else if(IsOperator(ch)){
				while(!stack.isEmpty() && hasHigherPrecedence(stack.peek(), ch)){
					res.add(String.valueOf(stack.pop()));
				}
				stack.push(ch);
			}else if(ch == '('){
				stack.push(ch);
			}else  if(ch == ')'){
				while(!stack.isEmpty() && stack.peek() != '('){
					res.add(String.valueOf(stack.pop()));
				}
				stack.pop();
			}
		}
		while(!stack.isEmpty()){
			res.add(String.valueOf(stack.pop()));
		}
		return res;
	}

	private boolean IsOperand(char C) 
	{
		if(C >= '0' && C <= '9') return true;
		if(C >= 'a' && C <= 'z') return true;
		if(C >= 'A' && C <= 'Z') return true;
		return false;
	}

	private boolean IsOperator(char C)
	{
		if(C == '+' || C == '-' || C == '*' || C == '/' || C== '$')
			return true;

		return false;
	}

	private boolean hasHigherPrecedence(char op1, char op2)
	{
		int op1Weight = getOperatorWeight(op1);
		int op2Weight = getOperatorWeight(op2);
		
		// If operators have equal precedence, return true if they are left associative. Left one should be given priority.
		// return false, if right associative. 
		if(op1Weight == op2Weight)
		{
			if(IsRightAssociative(op1)) return false;
			else return true;
		}
		return op1Weight > op2Weight ?  true: false;
	}
	
	private boolean IsRightAssociative(char op)
	{
		if(op == '$') return true;
		return false;
	}

	private int getOperatorWeight(char op)
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
}
