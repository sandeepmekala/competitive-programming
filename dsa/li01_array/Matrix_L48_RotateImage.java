package li01_array;

import java.util.Arrays;

public class Matrix_L48_RotateImage {

	public static void main(String[] args) {
		Matrix_L48_RotateImage obj = new Matrix_L48_RotateImage();
		int[][] matrix = new int[][] {
		{1,2,3},
		{4,5,6},
		{7,8,9}
		};

		obj.rotate(matrix);
		obj.print(matrix);
	}

	// Problem: https://leetcode.com/problems/rotate-image/
	// Idea: Transpose the matrix and then reverse each row.
	public void rotate(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;

        // transpose
        for(int i=0; i<m; i++){
            for(int j=i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse rows
        for(int i=0; i<m; i++){
            reverse(matrix[i]);
        }
    }

    private void reverse(int[] nums){
        int l = 0, r = nums.length-1;
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        }
    }

	private void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
        System.out.println();
	}
}
