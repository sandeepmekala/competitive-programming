package edu.algos.matrix;

public class SearchA2DMatrix {

	public static void main(String[] args) {
		SearchA2DMatrix obj = new SearchA2DMatrix();
		int[][] matrix = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		
		System.out.println(obj.searchMatrix(matrix, 5));
	}
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0, j=matrix[0].length-1;
        while(j>=0 && i<matrix.length){
            int num = matrix[i][j];
            if(num == target){
                return true;
            }else if(target < num){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }

}
