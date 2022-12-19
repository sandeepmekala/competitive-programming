package edu.algos.li12_stack;

import java.util.Stack;

public class MaxumumRectangleAreaInHistogram {

	public static void main(String[] args) {
		int[] histogram = new int[] {2,1,2,3,1};
		System.out.println(maxArea(histogram, histogram.length));
	}

	private static int maxArea(int[] histogram, int n) {
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int i;
		for(i=0; i<n; i++) {
			if( stack.isEmpty() || histogram[i] > histogram[stack.peek()]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && histogram[stack.peek()] > histogram[i]) {
					int top = stack.pop();
					int area;
					if(!stack.isEmpty()) {
						area = histogram[top] * (i - stack.peek() - 1);
					}else {
						area = histogram[top]*i;
					}
					if (area > maxArea) {
						maxArea = area;
					}
				}
				stack.push(i);
			}
		}
		while (!stack.isEmpty()) {
			int top = stack.pop();
			int area;
			if(!stack.isEmpty()) {
				area = histogram[top] * (i - stack.peek() - 1);
			}else {
				area = histogram[top]*i;
			}
			if (area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}

}
