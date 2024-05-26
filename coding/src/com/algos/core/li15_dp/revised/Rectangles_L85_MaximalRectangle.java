package  com.algos.core.li15_dp.revised;

import java.util.Stack;

public class Rectangles_L85_MaximalRectangle {

	public static void main(String[] args) {
		Rectangles_L85_MaximalRectangle obj = new Rectangles_L85_MaximalRectangle();
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
			int area = maxArea(histogram);
			if(area > max) {
				max = area;
			}
		}
		
		return max;
	}

	private int maxArea(int[] heights) {
		int n = heights.length;
        int maxArea = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<=n; i++) {
			while (!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])) {
				int top = stack.pop();
				int area;
				if(!stack.isEmpty()) {
					area = heights[top] * (i - stack.peek() - 1);
				}else {
					area = heights[top]*i;
				}
					
				maxArea = Math.max(maxArea, area);
			}
			stack.push(i);
		}
		return maxArea;
	}

}
