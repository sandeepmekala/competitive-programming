package edu.algos.li12.stack;

import java.util.Stack;

public class BaseballGame {

	public static void main(String[] args) {
		BaseballGame obj = new BaseballGame();
		
		String[] ops = new String[] {"5","2","C","D","+"};
		System.out.println(obj.calPoints(ops));
	}

	/*
	 * Problem: https://leetcode.com/problems/baseball-game/
	 * */
	public int calPoints(String[] ops) {
        Stack<Integer> scores = new Stack<>();
        for(String op: ops){
            if(op.equals("C")){
                scores.pop();
            }else if(op.equals("D")){
                scores.push(scores.peek()*2);
            }else if(op.equals("+")){
                int last1 = scores.pop();
                int last2 = scores.peek();
                scores.push(last1);
                scores.push(last1+last2);
            }else{
                int num = Integer.parseInt(op);
                scores.push(num);
            }
        }
        
        return scores.stream().reduce(0, (x,y) -> x+y);
    }
}
