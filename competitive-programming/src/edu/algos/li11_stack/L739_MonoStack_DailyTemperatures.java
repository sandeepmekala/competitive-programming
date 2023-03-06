package edu.algos.li11_stack;

import java.util.Arrays;
import java.util.Stack;

public class L739_MonoStack_DailyTemperatures {

	public static void main(String[] args) {
		L739_MonoStack_DailyTemperatures obj = new L739_MonoStack_DailyTemperatures();
		
		System.out.println(Arrays.toString(obj.dailyTemperatures(new int[] {73,74,75,71,69,72,76,73})));
	}

    // Problem: https://leetcode.com/problems/daily-temperatures/
    // Idea: Go left to right build monotonically decreasing stack. 
    // If you encounter an element greater then top of the stack, you found a match for top element.
    // Thumb Rule of Monotonic Stacks: If you need to find a greater element on the right side build a decreasing stack.
	public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while(i<n){
            if(stack.isEmpty() || temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i++);
            }else{
                result[stack.peek()] = i-stack.peek();
                stack.pop();
            }
        }
        
        return result;
    }
}
