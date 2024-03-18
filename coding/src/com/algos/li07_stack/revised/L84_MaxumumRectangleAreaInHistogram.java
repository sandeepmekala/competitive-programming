package  com.algos.li07_stack.revised;

import java.util.Stack;

public class L84_MaxumumRectangleAreaInHistogram {

	public static void main(String[] args) {
		L84_MaxumumRectangleAreaInHistogram obj = new L84_MaxumumRectangleAreaInHistogram();

		int[] histogram = new int[] { 2, 1, 2, 3, 1 };
		System.out.println(obj.largestRectangleArea(histogram));
		System.out.println(obj.largestRectangleArea2(histogram));
	}

	// Problem: https://leetcode.com/problems/largest-rectangle-in-histogram/
	// Idea: find the left and right mins and for each position and calculate the
	// area as (rightSmall-leftSmall+1) * height.
	// leftSmall will be actual left small index+1. Similarly, rightSmall will be right small index-1
	public int largestRectangleArea(int[] heights) {
		int n = heights.length;
		Stack<Integer> stack = new Stack<>();
		int leftSmall[] = new int[n];
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			
			if (stack.isEmpty())
				leftSmall[i] = 0;
			else
				leftSmall[i] = stack.peek() + 1;
			stack.push(i);
		}
		
		// clear the stack to be re-used
		while (!stack.isEmpty())
			stack.pop();
		
		int rightSmall[] = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}

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

	// Idea: Move left to right and maintain monotonically increasing stack.
	// Once it fails, calculate the area and track global max area.
	public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<=n; i++) {
			while (!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])) {
				int top = stack.pop();
				int area;
				if(!stack.isEmpty()) {
					area = heights[top] * (i - stack.peek() - 1);
				}else {
					area = heights[top]*i;
				}
				if (area > maxArea) {
					maxArea = area;
				}
			}
			stack.push(i);
		}
		return maxArea;
    }

}
