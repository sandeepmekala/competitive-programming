package  com.algos.core.li07_stack.revised;

import java.util.Arrays;
import java.util.Stack;

public class L739_MonoStack_DailyTemperatures {

	public static void main(String[] args) {
		L739_MonoStack_DailyTemperatures obj = new L739_MonoStack_DailyTemperatures();
		
		System.out.println(Arrays.toString(obj.dailyTemperatures(new int[] {73,74,75,71,69,72,76,73})));
	}

    // Problem: https://leetcode.com/problems/daily-temperatures/
    // Idea: Go right to left and build monotonically increasing stack. 
	public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                nge[i] = 0;
            else
                nge[i] = stack.peek()-i;

            stack.push(i);
        }
        
        return nge;
    }
}
