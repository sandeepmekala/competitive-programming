package edu.algos.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

	public static void main(String[] args) {
		DailyTemperatures obj = new DailyTemperatures();
		
		System.out.println(Arrays.toString(obj.dailyTemperatures(new int[] {73,74,75,71,69,72,76,73})));
	}

	public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while(i<n){
            if(stack.isEmpty()){
                stack.push(i);
                i++;
                continue;
            }
            
            if(temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);
                i++;
            }else{
                result[stack.peek()] = (i-stack.peek());
                stack.pop();
            }
        }
        
        return result;
    }
}
