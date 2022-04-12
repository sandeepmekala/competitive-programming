package edu.algos.dp;

import java.util.Stack;

public class Algo103_MatrixMaxRectangleOfAll1s {

	public static void main(String[] args) {
		Algo103_MatrixMaxRectangleOfAll1s obj = new Algo103_MatrixMaxRectangleOfAll1s();
		int[][] matrix = new int[][] {
			{1,0,0,1,1,1},
			{1,0,1,1,0,1},
			{0,1,1,1,1,1},
			{0,0,1,1,1,1}
		};
		System.out.println(obj.maxRecArea(matrix, matrix.length, matrix[0].length));
	}
	
	// concept: idea is to use max rec area in histogram logic to find the max area of 1's
	// for the subsequence rows cumulatively add rows so that we get bigger histograms by consecutive 1's in each column
	// time = O(rows*cols)
	// space = O(cols) 
	private int maxRecArea(int[][] matrix, int m, int n) {
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

	private static int[] add(int[] array1, int[] array2) {
		int[] temp = new int[array1.length];
		for(int i=0; i<array1.length; i++) {
			if(array2[i] != 0) {				//skip column the col as bottom of histogram can't be zero. It should be continuation of 1's
				temp[i] = array1[i]+array2[i];
			}
		}
		return temp;
	}

	private static int maxArea(int[] array, int n) {
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
