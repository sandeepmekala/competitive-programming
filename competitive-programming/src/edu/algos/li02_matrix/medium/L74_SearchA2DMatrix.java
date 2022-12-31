package edu.algos.li02_matrix.medium;

public class L74_SearchA2DMatrix {

	public static void main(String[] args) {
		L74_SearchA2DMatrix obj = new L74_SearchA2DMatrix();
		int[][] matrix = new int[][] { 
            { 1, 4, 7, 11, 15 }, 
            { 2, 5, 8, 12, 19 }, 
            { 3, 6, 9, 16, 22 },
            { 10, 13, 14, 17, 24 }, 
            { 18, 21, 23, 26, 30 } };

		System.out.println(obj.searchMatrix(matrix, 5));
	}

    // Problem: https://leetcode.com/problems/search-a-2d-matrix/
    // Idea: Use binary search from top-right corner
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0, j=matrix[0].length-1;
        while(j>=0 && i<matrix.length){
            int num = matrix[i][j];
            if(num == target){
                return true;
            }else if(target < num){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }

}
