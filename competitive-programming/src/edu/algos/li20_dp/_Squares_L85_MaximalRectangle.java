package edu.algos.li20_dp;

import java.util.Stack;

public class _Squares_L85_MaximalRectangle {

	public static void main(String[] args) {
		_Squares_L85_MaximalRectangle obj = new _Squares_L85_MaximalRectangle();
		char[][] matrix = new char[][] {
			{'1','0','0','1','1','1'},
			{'1','0','1','1','0','1'},
			{'0','1','1','1','1','1'},
			{'0','0','1','1','1','1'}
		};
		System.out.println(obj.maximalRectangle(matrix));
	}
	
	// Problem: https://leetcode.com/problems/maximal-rectangle/
	// Idea: Use max rec area in histogram logic to find the max area of 1's
	// For the subsequence of rows, cumulatively add rows so that we get bigger histograms by consecutive 1's in each column
	// Time = O(rows*cols)
	// Space = O(cols) 
	public int maximalRectangle(char[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int max = Integer.MIN_VALUE;
		int[] histogram = new int[n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++){
				if(matrix[i][j] == '1')
					histogram[j]++;
				else
					histogram[j] = 0;
			}
			int area = maxArea(histogram, histogram.length);
			if(area > max) {
				max = area;
			}
		}
		
		return max;
	}

	private int maxArea(int[] array, int n) {
		int maxArea = 0;
		int i;
		Stack<Integer> stack = new Stack<Integer>();
		for(i=0; i<n; i++) {
			if(stack.isEmpty() || array[i] > array[stack.peek()]) {
				stack.push(i);
			}else {
				while(!stack.isEmpty() && array[stack.peek()] > array[i]) {
					int top = stack.pop();
					int area;
					if(!stack.isEmpty()) {
						area = array[top]*(i-stack.peek()-1);
					}else {
						area = array[top]*i;
					}
					if(area > maxArea) {
						maxArea = area;
					}
				}
				stack.push(i);
			}
		}
		while(!stack.isEmpty()) {
			int top = stack.pop();
			int area;
			if(!stack.isEmpty()) {
				area = array[top]*(i-stack.peek()-1);
			}else {
				area = array[top]*i;
			}
			if(area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}

}
