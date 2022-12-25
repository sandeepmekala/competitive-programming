package edu.algos.li11_stack.hard;

import java.util.Stack;

public class L84_MaxumumRectangleAreaInHistogram {

	public static void main(String[] args) {
		L84_MaxumumRectangleAreaInHistogram obj = new L84_MaxumumRectangleAreaInHistogram();

		int[] histogram = new int[] {2,1,2,3,1};
		System.out.println(obj.largestRectangleArea(histogram));
	}

	// Problem: https://leetcode.com/problems/largest-rectangle-in-histogram/
	// Idea: Move left to right and maintain monotonically increasing stack.
	// Once it fails, calculate the area and track global max area.
	public int largestRectangleArea(int[] histogram) {
        int n = histogram.length;
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
