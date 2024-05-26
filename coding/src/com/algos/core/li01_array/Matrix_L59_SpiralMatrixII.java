package  com.algos.core.li01_array;

import java.util.Arrays;

public class Matrix_L59_SpiralMatrixII {

	public static void main(String[] args) {
		Matrix_L59_SpiralMatrixII obj = new Matrix_L59_SpiralMatrixII();
		int[][] matrix = obj.generateMatrix(3);
		for(int[] row: matrix) {
			System.out.println(Arrays.toString(row));
		}
	}

    // Problem: https://leetcode.com/problems/spiral-matrix-ii/
    // Idea: Use two pointers for each row/column and move the pointer once that row/column processed.
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
