package edu.algos.li21_dp2;

import java.util.Stack;

public class Dp24MaximalRectangle {

	public static void main(String[] args) {
		Dp24MaximalRectangle obj = new Dp24MaximalRectangle();
		char[][] matrix = new char[][] {
			{1,0,0,1,1,1},
			{1,0,1,1,0,1},
			{0,1,1,1,1,1},
			{0,0,1,1,1,1}
		};
		System.out.println(obj.maximalRectangle(matrix));
	}
	
	// Idea: idea is to use max rec area in histogram logic to find the max area of 1's
	// for the subsequence rows cumulatively add rows so that we get bigger histograms by consecutive 1's in each column
	// time = O(rows*cols)
	// space = O(cols) 
	public int maximalRectangle(char[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int globalMax = Integer.MIN_VALUE;
		int[] histogram = new int[n];
		for(int i=0; i<m; i++) {
			histogram = add(histogram, matrix[i]);
			int localMax = maxArea(histogram, histogram.length);
			if(localMax > globalMax) {
				globalMax = localMax;
			}
		}
		
		return globalMax;
	}

	private int[] add(int[] array1, char[] matrix) {
		int[] temp = new int[array1.length];
		for(int i=0; i<array1.length; i++) {
			if(matrix[i] == 1) {				//skip column the col as bottom of histogram can't be zero. It should be continuation of 1's
				temp[i] = array1[i]+1;
			}else {
				temp[i] = 0;
			}
		}
		return temp;
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
