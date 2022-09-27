package edu.algos.li21.dp2;

public class Dp21UniquePathsII {

	public static void main(String[] args) {
		Dp21UniquePathsII obj = new Dp21UniquePathsII();
		
		int[][] obstacleGrid = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/unique-paths-ii/
	 * Companies: Amazon
	 * */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] mem = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j] == 1) continue;
                
                if(i == 0 && j == 0) {
					mem[i][j] = 1;							//base case
				}else if(i == 0){
                    mem[i][j] = mem[i][j-1];   
                }else if(j == 0){
                    mem[i][j] = mem[i-1][j];
                }else{
                    mem[i][j] = mem[i-1][j]+mem[i][j-1];
                }
            }
        }
        
        return mem[m-1][n-1];
    }

}
