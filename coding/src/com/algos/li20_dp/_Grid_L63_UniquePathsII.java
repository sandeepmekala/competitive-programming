package  com.algos.li20_dp;

public class _Grid_L63_UniquePathsII {

	public static void main(String[] args) {
		_Grid_L63_UniquePathsII obj = new _Grid_L63_UniquePathsII();
		
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
    // Time: O(m*n)
    // Space: O(m*n)
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        int[][] ways = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j] == 1){
                    ways[i][j] = 0;
                }else if(i == 0 && j == 0) {
					ways[i][j] = 1;							//base case
				}else{
                    int up = 0, left = 0;
                    if(i>0) up = ways[i-1][j];
					if(j>0) left = ways[i][j-1];
					ways[i][j] = up+left;
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
