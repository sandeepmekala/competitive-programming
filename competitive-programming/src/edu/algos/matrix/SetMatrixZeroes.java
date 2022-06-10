package edu.algos.matrix;

import java.util.Arrays;

public class SetMatrixZeroes {

	public static void main(String[] args) {
		SetMatrixZeroes obj = new SetMatrixZeroes();
		int[][] matrix = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
		for(int[] row: matrix) {
			System.out.println(Arrays.toString(row));
		}
		
	}

	public void setZeroes(int[][] matrix) {
        int tempI = 1,tempJ = 1;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    if(i == 0){
                        tempI = 0;
                    }
                    if(j == 0){
                        tempJ = 0;
                    }
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
        
        if(tempI == 0){
            for(int j=0; j<matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
        if(tempJ == 0){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
