package  com.algos.li01_array.revised;

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
        int top = 0, bottom = matrix.length-1, left = 0, right = matrix[0].length-1;
        List<Integer> result = new ArrayList<>();
        while(top <= bottom && left <= right){
            for(int i=left; i<=right; i++){
                result.add(matrix[top][i]);           
            }
            top++;
            for(int i=top; i<=bottom; i++){
                result.add(matrix[i][right]);   
            }
            right--;
            if(top <= bottom){          // go r -> l only if there is a row to process
                for(int i=right; i>=left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            if(left <= right){          // go b -> t only if there is a row to process
                for(int i = bottom; i>=top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
}
