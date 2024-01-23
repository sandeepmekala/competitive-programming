package edu.algos.li01_array;

public class _Matrix_L48_RotateImage {

	public static void main(String[] args) {
		_Matrix_L48_RotateImage obj = new _Matrix_L48_RotateImage();
		int[][] matrix = new int[][] {
		{1,2,3}, 
		{4,5,6}, 
		{7,8,9}
		};

		obj.print(matrix);
		obj.rotate(matrix);
		obj.print(matrix);
	}

	// Problem: https://leetcode.com/problems/rotate-image/
	// Idea: Use two pointers for each row/column and move the pointer once that row/column processed.
    // You can also solve it by doing transpose of matrix
	public void rotate(int[][] matrix) {
        int si = 0, sj = 0, ei = matrix.length-1, ej = matrix.length-1; 
        while(si<ei && sj<ej){
            //left->top
            for(int j=sj,i=ei; j<ej; j++,i--){
                int temp = matrix[si][j];
                matrix[si][j] = matrix[i][sj];
                matrix[i][sj] = temp;
            }
            
            //bottom->left
            for(int i=ei,j=ej; i>si; i--,j--){
                int temp = matrix[i][sj];
                matrix[i][sj] = matrix[ei][j];
                matrix[ei][j] = temp;
            }
            
            //right->bottom
            for(int j=ei,i=si; j>si; j--,i++){
                int temp = matrix[ei][j];
                matrix[ei][j] = matrix[i][ej];
                matrix[i][ej] = temp;
            }
            
            si++;
            ei--;
            sj++;
            ej--;
        }
    }

	private void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
