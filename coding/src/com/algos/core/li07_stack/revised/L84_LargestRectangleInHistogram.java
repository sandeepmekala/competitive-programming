package  com.algos.core.li07_stack.revised;

import java.util.Stack;

public class L84_LargestRectangleInHistogram {

	public static void main(String[] args) {
		L84_LargestRectangleInHistogram obj = new L84_LargestRectangleInHistogram();

		int[] histogram = new int[] { 2, 1, 2, 3, 1 };
		System.out.println(obj.largestRectangleArea(histogram));
		System.out.println(obj.largestRectangleArea2(histogram));
	}

	// Problem: https://leetcode.com/problems/largest-rectangle-in-histogram/
	// Idea: Find the left and right mins and for each position and calculate the
	// area as (rightSmall-leftSmall+1) * height.
	// leftSmall will be actual_left_small_index+1. Similarly, rightSmall will be right_small_index-1
	public int largestRectangleArea(int[] heights) {
		int n = heights.length;

		Stack<Integer> stack = new Stack<>();
		int leftSmall[] = new int[n];
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) 
				stack.pop();
			
			if (stack.isEmpty())
				leftSmall[i] = 0;
			else
				leftSmall[i] = stack.peek() + 1;
			stack.push(i);
		}
		
		// clear the stack to be re-used
		stack.clear();

		int rightSmall[] = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) 
				stack.pop();

			if (stack.isEmpty())
				rightSmall[i] = n - 1;
			else
				rightSmall[i] = stack.peek() - 1;

			stack.push(i);
		}

		int maxArea = 0;
		for (int i = 0; i < n; i++) {
			maxArea = Math.max(maxArea, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
		}
		return maxArea;
	}

	// Idea: Move left to right.
	// As we move left to right the stack will be monotonically increasing stack.
	// Means every el will have its left smaller el below it in stack. 
	// For mono inc stack, if curr el is smaller then the top of stack, then we pop the stack.
	// That means we have found the right smaller el for the top of stack.
	// Then calculate the area for top of stack el while you remove it.
	// Track global max area.
	public int largestRectangleArea2(int[] heights) {
        int n = heights.length;

        int maxArea = 0;
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<=n; i++) {			// We go till i=n as stack might have some elements left.
			while (!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])) {
				int top = st.pop();
				int rightSmall = i;
				int leftSmall = !st.isEmpty() ? st.peek() : -1;

				int area = heights[top] * (rightSmall - leftSmall - 1);
				if (area > maxArea) {
					maxArea = area;
				}
			}
			st.push(i);
		}
		return maxArea;
    }

}
