package  com.algos.topics.li01_array;

import java.util.Arrays;

public class Kadanes_MaximumSumRectangle_Kadanes {

	public static void main(String[] args) {
		Kadanes_MaximumSumRectangle_Kadanes obj = new Kadanes_MaximumSumRectangle_Kadanes();
		int[][] matrix = new int[][] {
			{2,1,-3,-4,5},
			{0,6,3,4,1},
			{2,-2,-1,4,-5},
			{-3,3,1,0,3}
		};
		System.out.println(Arrays.toString(obj.maxSum(matrix, matrix.length, matrix[0].length)));
	}

	/*
	 * Problem:
	 * Idea: Find cumulative sum array from left to right cols. Apply Kadanes algo on that cumulative col sum array. Kadanes algo gives you local max, top and bottom indices.
	 * these left right indices you can use as left max and right max if kadanes algo return max which is greater than global max.
	 *
	 *
	 * */
	// Time: O(col*col*row)
	// space: O(row)
	private int[] maxSum(int[][] matrix, int m, int n) {
		int maxSum = Integer.MIN_VALUE;
		int li = -1, ri = -1, ti = -1, di = -1;

		for(int i=0; i<n; i++) {
			int[] summedCol = new int[m];
			for(int j=i; j<n; j++) {
				int[] currentCol = getColumn(matrix, j);
				summedCol = add(summedCol, currentCol);

				int[] res = kadanesAlgo(summedCol, m);
				if(res[0] > maxSum) {
					maxSum = res[0];
					li = i;
					ri = j;
					ti = res[1];
					di = res[2];
				}
			}
		}
		return new int[] {maxSum, li, ti, ri, di};
	}

	private int[] kadanesAlgo(int[] array, int m) {
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		int start = -1, end = -1;
		for(int i=0; i<m; i++) {
			sum += array[i];
			if(sum > maxSum) {
				maxSum = sum;
				end = i;
			}
			if(sum < 0) {
				sum = 0;
				start = i+1;
			}
		}
		return new int[] {maxSum, start, end};
	}

	private int[] add(int[] array1, int[] array2) {
		int temp[] = new int[array1.length];
		for(int i=0; i<array1.length; i++) {
			temp[i] = array1[i]+array2[i];
		}
		return temp;
	}

	private int[] getColumn(int[][] matrix, int j) {
		int[] column = new int[matrix.length];
		for(int i=0; i<matrix.length; i++) {
			column[i] = matrix[i][j];
		}
		return column;
	}
}
