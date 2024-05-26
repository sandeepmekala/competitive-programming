package  com.algos.core.li07_stack.revised;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L224_BasicCalculator {
    public static void main(String[] args) {
        L224_BasicCalculator obj = new L224_BasicCalculator();

        // String s = " 2-1 + 2 ";              // 3
        // String s = "(1+(4+5+2)-3)+(6+8)";    // 23
        // String s = "1-(     -2)";               // 3
		String s = "-2+5";               // 3
        System.out.println(obj.calculate(s));
    }

	// Problem: https://leetcode.com/problems/basic-calculator
    public int calculate(String s) {
        List<String> postfix = infixToPostfix(s);
        System.out.println(postfix);
        String[] postfixArr = new String[postfix.size()];
        postfixArr = postfix.toArray(postfixArr);
        return evalPostfix(postfixArr);
    }

	// Idea: Push operators and paranthesis to stack and pop them when we encounter closing paranthesis
	// When we encounter a number, push it to res
	// When we encounter an operator, pop all the operators from stack with higher precedence and push them to res
	// Wrap input in () to handle unary operators
	// Add 0 to res when we encounter - unary operator 
    public List<String> infixToPostfix(String s){
		Stack<Character> stack = new Stack<Character>();
		List<String> res = new ArrayList<String>();
		s = "("+s+")";						//wrap it in brackets for -2+5 kind of cases to handle unary
		boolean checkUnary = false;
		for(int i=0; i<s.length(); i++){
			char ch = s.charAt(i);
			if(ch == ' ') continue;

			if(checkUnary){
				if(ch == '-')
					res.add("0");
				checkUnary = false;
			}

			if(Character.isDigit(ch)){
                String num = String.valueOf(ch);
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))) 
					num += s.charAt(++i);
                
				res.add(num);
			}else if(ch == '('){
				stack.push(ch);
				checkUnary = true;
			}else if(ch == ')'){
				while(!stack.isEmpty() && stack.peek() != '('){
					res.add(String.valueOf(stack.pop()));
				}
				stack.pop();
			}else{
				while(!stack.isEmpty() && weight(stack.peek()) >= weight(ch)){
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

    private int weight(char op)	{
		if(op == '+' || op == '-') return 1;
		else return -1;
	}

    public int evalPostfix(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();	
		for(int i=0; i<tokens.length; i++){
			if(!tokens[i].equals("+") && !tokens[i].equals("-"))  { 
				stack.push(Integer.parseInt(tokens[i]));
			}else{
				int op2 = stack.pop();	
				int op1 = stack.pop();	
				if(tokens[i].equals("+")) stack.push(op1+op2);
				else stack.push(op1-op2);	
			}
		}
		return stack.pop();
	}
}
