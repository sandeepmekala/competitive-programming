package edu.algos.dp;

import java.util.Arrays;

public class MaximumSumRectangleKadanesAlgo {

	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{2,1,-3,-4,5},
			{0,6,3,4,1},
			{2,-2,-1,4,-5},
			{-3,3,1,0,3}
		};
		System.out.println(Arrays.toString(maxSum(matrix, matrix.length, matrix[0].length)));
	}

	//Time = O(col*col*row)
	//Space = O(row)
	private static int[] maxSum(int[][] matrix, int m, int n) {
		int globalMax = Integer.MIN_VALUE;
		int leftMax = -1;
		int rightMax = -1;
		int topMax = -1;
		int downMax = -1;
		
		for(int l=0; l<n; l++) {
			int[] tempCol = new int[m];
			for(int r=l; r<n; r++) {
				int[] currentCol = getColumn(matrix, r);
				tempCol = add(tempCol, currentCol);
				int[] currentAns = kadanesAlgo(tempCol, m);
				int currentMax = currentAns[0];
				if(currentMax > globalMax) {
					globalMax = currentMax;
					leftMax = l;
					rightMax = r;
					topMax = currentAns[1];
					downMax = currentAns[2];
				}
			}
		}
		return new int[] {globalMax, leftMax, topMax, rightMax, downMax};
	}
	private static int[] kadanesAlgo(int[] array, int m) {
		int globalMax = Integer.MIN_VALUE;
		int currentMax = 0;
		int tempStart = 0;
		int start = -1;
		int end = -1;
		for(int i=0; i<m; i++) {
			currentMax += array[i];
			if(currentMax > globalMax) {
				globalMax = currentMax;
				start = tempStart;
				end = i;
			}
			if(currentMax < 0) {
				currentMax = 0;
				tempStart = i+1;
			}
		}
		return new int[] {globalMax, start, end};
	}

	private static int[] add(int[] array1, int[] array2) {
		int temp[] = new int[array1.length];
		for(int i=0; i<array1.length; i++) {
			temp[i] = array1[i]+array2[i];
		}
		return temp;
	}
	
	private static int[] getColumn(int[][] matrix, int index) {
		int[] column = new int[matrix.length];
		for(int i=0; i<matrix.length; i++) {
			column[i] = matrix[i][index];
		}
		return column;
	}
	

}
