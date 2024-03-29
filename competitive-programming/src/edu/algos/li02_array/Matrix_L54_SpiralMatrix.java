package edu.algos.li02_array;

import java.util.ArrayList;
import java.util.List;

public class Matrix_L54_SpiralMatrix {

	public static void main(String[] args) {
		Matrix_L54_SpiralMatrix obj = new Matrix_L54_SpiralMatrix();
		System.out.println(obj.spiralOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));
	}

    // Problem: https://leetcode.com/problems/spiral-matrix/
    // Idea: Use two pointers for each row/column and move the pointer once that row/column processed.
	public List<Integer> spiralOrder(int[][] matrix) {
        int startI = 0, startJ = 0, endI = matrix.length-1, endJ = matrix[0].length-1;
        List<Integer> result = new ArrayList<Integer>();
        while(startI < endI && startJ < endJ){
            for(int j=startJ; j<=endJ; j++){
                result.add(matrix[startI][j]);           
            }
            startI++;
            for(int i=startI; i<=endI; i++){
                result.add(matrix[i][endJ]);   
            }
            endJ--;
            for(int j=endJ; j>=startJ; j--){
                result.add(matrix[endI][j]);
            }
            endI--;
            for(int i = endI; i>=startI; i--){
                result.add(matrix[i][startJ]);
            }
            startJ++;
        }
        
        if(startI == endI && startJ < endJ){
            for(int j=startJ; j<=endJ; j++){
                result.add(matrix[startI][j]);           
            }
        }
        
        if(startI < endI && startJ == endJ){
            for(int i=startI; i<=endI; i++){
                result.add(matrix[i][endJ]);   
            }
        }
        
        if(startI == endI && startJ == endJ){
            result.add(matrix[startI][endI]);   
        }
        
        return result;
    }
}
