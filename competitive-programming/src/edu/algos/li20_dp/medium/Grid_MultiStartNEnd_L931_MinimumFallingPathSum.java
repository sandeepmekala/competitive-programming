package edu.algos.li20_dp.medium;

public class Grid_MultiStartNEnd_L931_MinimumFallingPathSum {
    public static void main(String[] args) {
        Grid_MultiStartNEnd_L931_MinimumFallingPathSum obj = new Grid_MultiStartNEnd_L931_MinimumFallingPathSum();

        int[][] matrix = new int[][]{{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(obj.minFallingPathSum(matrix));
    }

    // Problem: https://leetcode.com/problems/minimum-falling-path-sum/
    // Idea: Same as triangle problem, but there can be multiple source. Hence, we need to start recursion from each column and take max of all the col maxes.
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;

        int[][] cost = new int[m][n];
        for(int j=0; j<n; j++){
            cost[0][j] = matrix[0][j];
        }
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                int l = matrix[i][j] + cost[i-1][j];
                int ld = (j-1>=0)?  matrix[i][j] + cost[i-1][j-1] : (int)1e9;
                int rd = (j+1<m)?  matrix[i][j] + cost[i-1][j+1] : (int)1e9;

                cost[i][j] = Math.min(l, Math.min(ld, rd));
            }
        }

        int min = (int)1e9;
        for(int j=0; j<n; j++){
            min = Math.min(min, cost[n-1][j]);
        }
        return min;
    }

    public int minFallingPathSumRec(int[][] matrix) {
        int min = (int)1e8, m=matrix.length;
        for(int j=0; j<matrix[0].length; j++){
            min = Math.min(min, minFallingPathSum(matrix, m-1, j));
        }
        return min;
    }

    private int minFallingPathSum(int[][] matrix, int i, int j) {
        if(j<0 || j>=matrix[0].length)
            return (int)1e8;
        if(i==0)
            return matrix[i][j];

        int l = matrix[i][j] + minFallingPathSum(matrix, i-1, j);
        int ld = matrix[i][j] + minFallingPathSum(matrix, i-1, j-1);
        int rd = matrix[i][j] + minFallingPathSum(matrix, i-1, j+1);

        return Math.min(l, Math.min(ld, rd));
    }
}
