package  com.algos.core.li01_array.revised;

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
    // Idea: If you find 0 in any cell mark that row and col in first row and col.
	public void setZeroes(int[][] matrix) {
        boolean firstRow0 = false, firstCol0 = false;
        int rows = matrix.length, cols = matrix[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(matrix[i][j] == 0){
                    if(i == 0)
                        firstRow0 = true;
                    if(j == 0)
                        firstCol0 = true;

                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        
        for(int i=rows-1; i>=0; i--){
            for(int j=cols-1; j>=0; j--){ 
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
