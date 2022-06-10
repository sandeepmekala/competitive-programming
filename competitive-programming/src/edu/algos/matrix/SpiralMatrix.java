package edu.algos.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		SpiralMatrix obj = new SpiralMatrix();
		System.out.println(obj.spiralOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));
	}

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
