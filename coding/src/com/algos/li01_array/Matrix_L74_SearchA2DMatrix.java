package  com.algos.li01_array;

public class Matrix_L74_SearchA2DMatrix {

	public static void main(String[] args) {
		Matrix_L74_SearchA2DMatrix obj = new Matrix_L74_SearchA2DMatrix();
		int[][] matrix = new int[][] { 
            { 1, 4, 7, 11, 15 }, 
            { 2, 5, 8, 12, 19 }, 
            { 3, 6, 9, 16, 22 },
            { 10, 13, 14, 17, 24 }, 
            { 18, 21, 23, 26, 30 } };

		System.out.println(obj.searchMatrix(matrix, 5));
	}

    // Problem: https://leetcode.com/problems/search-a-2d-matrix/
    // Idea: There are 2 variations of this problem.
    // 1. each row and columns are in increasing order
    // 2. each row and columns are in increasing order and first element of next is greater then last element of curr row.
    // Boelow algo is best for 1st case. Use binary search from top-right corner.
    // For 2nd case optimal approach is to apply BS on range 0 to n*m-1 as the elments are continueously increasing from 0 to n*m-1.
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
