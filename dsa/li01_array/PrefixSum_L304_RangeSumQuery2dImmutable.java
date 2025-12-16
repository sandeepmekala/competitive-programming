
public class PrefixSum_L304_RangeSumQuery2dImmutable {

	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{3,0,1,4,2},
			{5,6,3,2,1},
			{1,2,0,1,5},
			{4,1,0,1,7},
			{1,0,3,0,5}};
		PrefixSum_L304_RangeSumQuery2dImmutable obj = new PrefixSum_L304_RangeSumQuery2dImmutable(matrix);

		System.out.println(obj.sumRegion(2, 1, 4, 3));
	}

	/*
	 * Problem: https://leetcode.com/problems/range-sum-query-2d-immutable/
	 * Companies: Amazon
     * Idea: Calculate the prefix sum of each cell in matrix
	 * */

	int[][] prefixSum;
    public PrefixSum_L304_RangeSumQuery2dImmutable(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        prefixSum = new int[m+1][n+1];
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                prefixSum[i][j] = matrix[i-1][j-1] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        sum += prefixSum[row2+1][col2+1];
        sum -= prefixSum[row1][col2+1];
        sum -= prefixSum[row2+1][col1];
        sum += prefixSum[row1][col1];

        return sum;
    }
}
