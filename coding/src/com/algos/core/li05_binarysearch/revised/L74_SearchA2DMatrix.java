package  com.algos.core.li05_binarysearch.revised;

public class L74_SearchA2DMatrix {

	public static void main(String[] args) {
		L74_SearchA2DMatrix obj = new L74_SearchA2DMatrix();
		int[][] matrix = new int[][] { 
            { 1, 4, 7, 11, 15 }, 
            { 2, 5, 8, 12, 19 }, 
            { 3, 6, 9, 16, 22 },
            { 10, 13, 14, 17, 24 }, 
            { 18, 21, 23, 26, 30 } };

		System.out.println(obj.searchMatrix(matrix, 5));
	}

    // Problem: https://leetcode.com/problems/search-a-2d-matrix/
    // Idea: Each row and columns are in increasing order and first element of next row is greater then last element of curr row.
    // For this case optimal approach is to apply BS on range 0 to n*m-1 as the elments are continueously increasing from 0 to n*m-1.
    public boolean searchMatrix(int[][] mat, int target) {
        int m = mat.length, n = mat[0].length;
        int low = 0, high = m*n-1;
        while(low <= high){
            int mid = (low+high)/2;
            int row = mid/n, col = mid%n;
            if(mat[row][col] == target){
            if(mat[row][col] == target){
                return true;
            }else if(mat[row][col] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return false;
    }
}
