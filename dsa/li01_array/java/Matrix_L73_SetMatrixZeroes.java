package li01_array.java;

import java.util.Arrays;

public class Matrix_L73_SetMatrixZeroes {

	public static void main(String[] args) {
		Matrix_L73_SetMatrixZeroes obj = new Matrix_L73_SetMatrixZeroes();
		int[][] matrix = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
        obj.setZeroes(matrix);
		for(int[] row: matrix)
			System.out.println(Arrays.toString(row));
	}

    // Problem: https://leetcode.com/problems/set-matrix-zeroes/
    // If you find 0 in any cell mark that row and col as 0.
    // Idea: Mark in first row and col of you see any 0's.
	public void setZeroes(int[][] matrix) {
        boolean firstRow0 = false, firstCol0 = false;
        int m = matrix.length, n = matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    if(i == 0)
                        firstRow0 = true;
                    if(j == 0)
                        firstCol0 = true;

                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(i == 0){
                    if(firstRow0)
                        matrix[0][j] = 0;
                }else if(j == 0){
                    if(firstCol0)
                        matrix[i][0] = 0;
                }else if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
