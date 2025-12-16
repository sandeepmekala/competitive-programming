package li07_stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L227_BasicCalculatorII {
    public static void main(String[] args) {
        L227_BasicCalculatorII obj = new L227_BasicCalculatorII();

        String s = "3+20*2";
        System.out.println(obj.calculate(s));
    }

    // Problem: https://leetcode.com/problems/basic-calculator-ii/
    // Idea: Convert infix to postfix and evaulate postfix. To handle unary operators, unary operator can only occur in the begenning of exp or after (.
	// Hence, wrap exp in () to bring it to one case. Hendle after ( case with a separate flag.
    public int calculate(String s) {
        List<String> postfix = infixToPostfix(s);
        System.out.println(postfix);
        String[] postfixArr = new String[postfix.size()];
        postfixArr = postfix.toArray(postfixArr);
        return evalPostfix(postfixArr);
    }

    private List<String> infixToPostfix(String s){
		Stack<Character> stack = new Stack<Character>();
		List<String> res = new ArrayList<String>();
		for(int i=0; i<s.length(); i++){
			char ch = s.charAt(i);
			if(ch ==  ' ') continue;

			if(Character.isDigit(ch)){
                String num = String.valueOf(ch);
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1)))
					num += s.charAt(++i);

				res.add(num);
			}else {										// operator
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

    private int weight(char op)
	{
		if(op == '+' || op == '-') return 1;
        else if(op == '*' || op == '/') return 2;
		else return -1;
	}

    public int evalPostfix(String[] tokens) {
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
