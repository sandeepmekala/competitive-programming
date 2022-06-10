package edu.algos.dp2;

import java.util.Arrays;

public class Algo104_MatrixMaximumSumRectangleKadanesAlgo {

	public static void main(String[] args) {
		Algo104_MatrixMaximumSumRectangleKadanesAlgo obj = new Algo104_MatrixMaximumSumRectangleKadanesAlgo();
		int[][] matrix = new int[][] {
			{2,1,-3,-4,5},
			{0,6,3,4,1},
			{2,-2,-1,4,-5},
			{-3,3,1,0,3}
		};
		System.out.println(Arrays.toString(obj.maxSum(matrix, matrix.length, matrix[0].length)));
	}

	/*
	 * concept: find cumulative sum array from left to right cols. Apply Kadanes algo on that cumulative col sum array. Kadanes algo gives you local max, top and bottom indices.
	 * these left right indices you can use as left max and right max if kadanes algo return max which is greater than global max. 
	 * 
	 * 
	 * 
	 * */
	// time: O(col*col*row)
	// space: O(row)
	private int[] maxSum(int[][] matrix, int m, int n) {
		int globalMax = Integer.MIN_VALUE;
		int leftMaxInd = -1, rightMaxInd = -1, topMaxInd = -1, downMaxInd = -1;
		
		for(int l=0; l<n; l++) {
			int[] summedCol = new int[m];
			for(int r=l; r<n; r++) {
				int[] currentCol = getColumn(matrix, r);
				summedCol = add(summedCol, currentCol);
				int[] currentAns = kadanesAlgo(summedCol, m);
				int currentMax = currentAns[0];
				if(currentMax > globalMax) {
					globalMax = currentMax;
					leftMaxInd = l;
					rightMaxInd = r;
					topMaxInd = currentAns[1];
					downMaxInd = currentAns[2];
				}
			}
		}
		return new int[] {globalMax, leftMaxInd, topMaxInd, rightMaxInd, downMaxInd};
	}
	
	private int[] kadanesAlgo(int[] array, int m) {
		int globalMax = Integer.MIN_VALUE;
		int currentMax = 0;
		int tempStart = 0, start = -1, end = -1;
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

	private int[] add(int[] array1, int[] array2) {
		int temp[] = new int[array1.length];
		for(int i=0; i<array1.length; i++) {
			temp[i] = array1[i]+array2[i];
		}
		return temp;
	}
	
	private int[] getColumn(int[][] matrix, int index) {
		int[] column = new int[matrix.length];
		for(int i=0; i<matrix.length; i++) {
			column[i] = matrix[i][index];
		}
		return column;
	}
}
