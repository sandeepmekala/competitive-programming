package edu.algos.li02.matrix;

public class CountNegativeNumbersInASortedMatrix {

	public static void main(String[] args) {
		CountNegativeNumbersInASortedMatrix obj = new CountNegativeNumbersInASortedMatrix();
		
		int[][] grid = new int[][]{
			{4,3,2,-1},
			{3,2,1,-1},
			{1,1,-1,-2},
			{-1,-1,-2,-3}};
			
		System.out.println(obj.countNegatives(grid));
	}

	/*
	 * Problem: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
	 * 
	 * */
	public int countNegatives(int[][] grid) {
        int count = 0, m=grid.length, n=grid[0].length;
        int i=0, j=n-1;
        while(i<m && j>=0){
            if(grid[i][j] < 0){
                count += (m-i);
                j--;
            }else{
                i++;
            }
        }
        
        return count;
    }
}
