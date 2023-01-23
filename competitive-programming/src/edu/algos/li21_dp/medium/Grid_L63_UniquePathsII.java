package edu.algos.li21_dp.medium;

public class Grid_L63_UniquePathsII {

	public static void main(String[] args) {
		Grid_L63_UniquePathsII obj = new Grid_L63_UniquePathsII();
		
		int[][] obstacleGrid = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        System.out.println(obj.uniquePathsWithObstacles(m-1, n-1, obstacleGrid));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/unique-paths-ii/
	 * Companies: Amazon
     * Idea: Same as unique paths. If the cell has obstacle, just assign its ways as 0 so that for subsequent cells that path won't be considered.
	 * */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        int[][] ways = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j] == 1){
                    ways[i][j] = 0;
                }else if(i == 0 && j == 0) {
					ways[i][j] = 1;							//base case
				}else if(i == 0){
                    ways[i][j] = ways[i][j-1];   
                }else if(j == 0){
                    ways[i][j] = ways[i-1][j];
                }else{
                    ways[i][j] = ways[i-1][j]+ways[i][j-1];
                }
            }
        }
        
        return ways[m-1][n-1];
    }

    public int uniquePathsWithObstacles(int i, int j, int[][] obstacleGrid) {
        if(i == 0 && j == 0)
            return 1;
		if(i < 0 || j < 0)
            return 0;  
        if(obstacleGrid[i][j] == 1)
            return 0;

		int up = uniquePathsWithObstacles(i-1, j, obstacleGrid);
		int left = uniquePathsWithObstacles(i, j-1, obstacleGrid);
		return up+left;
	}

}
