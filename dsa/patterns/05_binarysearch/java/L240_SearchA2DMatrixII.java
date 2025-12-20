public class L240_SearchA2DMatrixII {

	public static void main(String[] args) {
		L240_SearchA2DMatrixII obj = new L240_SearchA2DMatrixII();
		int[][] matrix = new int[][] {
            { 1, 4, 7, 11, 15 },
            { 2, 5, 8, 12, 19 },
            { 3, 6, 9, 16, 22 },
            { 10, 13, 14, 17, 24 },
            { 18, 21, 23, 26, 30 } };

		System.out.println(obj.searchMatrix(matrix, 5));
	}

    // Problem: https://leetcode.com/problems/search-a-2d-matrix-ii/
    // Idea: When you look at the top right corner of the matrix, it has the property that all the elements in the left are smaller and all the elements in the bottom are larger.
    // So, if the target is smaller than the current element, then it must be in the left column and if the target is larger than the current element, then it must be in the bottom row.
    // Every time we eliminate one row or one column. Hence BS.
    // Time: O(m+n)
    public boolean searchMatrix(int[][] mat, int target) {
        int m = 0, n = mat[0].length-1;
        while(n >= 0 && m < mat.length){
            int num = mat[m][n];
            if(num == target){
                return true;
            }else if(target < num){
                n--;
            }else{
                m++;
            }
        }
        return false;
    }

}
