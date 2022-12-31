package edu.algos.li02_matrix.medium;

import java.util.Arrays;

public class L73_SetMatrixZeroes {

	public static void main(String[] args) {
		L73_SetMatrixZeroes obj = new L73_SetMatrixZeroes();
		int[][] matrix = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
        obj.setZeroes(matrix);
		for(int[] row: matrix) {
			System.out.println(Arrays.toString(row));
		}
	}

    // Problem: https://leetcode.com/problems/set-matrix-zeroes/
    // Idea: If you find 0 in any cell mark that row and col in first row and col.
	public void setZeroes(int[][] matrix) {
        boolean setFirstRowToZero = false, setFirstColToZero = false;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    if(i == 0)
                        setFirstRowToZero = true;
                    if(j == 0)
                        setFirstColToZero = true;

                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for(int i=1; i<matrix.length; i++){
            if(matrix[i][0] == 0){
                for(int j=1; j<matrix[i].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }
       
        for(int j=1; j<matrix[0].length; j++){
            if(matrix[0][j] == 0){
                for(int i=1; i<matrix.length; i++){
                    matrix[i][j] = 0;
                }    
            }
        }
        
        if(setFirstRowToZero){
            for(int j=0; j<matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
        if(setFirstColToZero){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
