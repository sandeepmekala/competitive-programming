package edu.algos.matrix;

import java.util.Arrays;

public class SpiralMatrixII {

	public static void main(String[] args) {
		SpiralMatrixII obj = new SpiralMatrixII();
		int[][] matrix = obj.generateMatrix(3);
		for(int[] row: matrix) {
			System.out.println(Arrays.toString(row));
		}
	}

	public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int startI = 0, startJ = 0, endI = matrix.length-1, endJ = matrix[0].length-1;
        int counter = 1;
        while(startI < endI && startJ < endJ){
            for(int j=startJ; j<=endJ; j++){
                matrix[startI][j] =  counter++;          
            }
            startI++;
            for(int i=startI; i<=endI; i++){
                matrix[i][endJ] = counter++;  
            }
            endJ--;
            for(int j=endJ; j>=startJ; j--){
                matrix[endI][j] = counter++;
            }
            endI--;
            for(int i = endI; i>=startI; i--){
                matrix[i][startJ] = counter++;
            }
            startJ++;
        }
        
        if(startI == endI && startJ < endJ){
            for(int j=startJ; j<=endJ; j++){
                matrix[startI][j] = counter++;          
            }
        }
        
        if(startI < endI && startJ == endJ){
            for(int i=startI; i<=endI; i++){
                matrix[i][endJ] = counter++;
            }
        }
        
        if(startI == endI && startJ == endJ){
            matrix[startI][endI] = counter++;   
        }
        
        return matrix;
    }
}
