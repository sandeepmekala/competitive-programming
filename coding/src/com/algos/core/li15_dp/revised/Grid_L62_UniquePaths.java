package  com.algos.core.li15_dp.revised;

public class Grid_L62_UniquePaths {

	public static void main(String[] args) {
		Grid_L62_UniquePaths obj = new Grid_L62_UniquePaths();

		int[][] matrix = new int[4][4] ;
		int m = matrix.length, n = matrix[0].length;
		System.out.println(obj.uniquePaths(m, n));
		System.out.println(obj.uniquePaths2(m, n));
	}

	// Problem: https://leetcode.com/problems/unique-paths/
	// Idea: As there are only 2 directions to move, you can reach any position from the top or left. 
	// So total ways to reach any position is ways to reach top + ways to reach left
	// 
	// i\j	0	1	2	3
	// 0	1	1	1	1
	// 1	1	2	3	4
	// 2	1	3	6	10
	// 3	1	4	10	20
	// 
	// The same problem can be solved as combinatotics problem.
	// We have to m-1 down and n-1 right directions to reach target. Total will (m-1)+(n-1) = m+n-2.
	// Out of these m+n-2 direction we need to choose either m-1 down direction or n-1 right directions.
	// Hence, ans will be (m+n-2)C(m-1) or (m+n-2)C(n-1)
	// 
	// Time: O(m*n)
    // Space: O(m*n)
	public int uniquePaths2(int i, int j) {
		if(i == 0 && j == 0)
			return 1;

		int up = 0, left = 0;
		if(i>0) up = uniquePaths(i-1, j);
		if(j>0) left = uniquePaths(i, j-1);

		return up+left;
	}

	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(i == 0 && j == 0) {
					dp[i][j] = 1;							//base case
				}else {
					int up = 0, left = 0;
                    if(i>0) up = dp[i-1][j];
					if(j>0) left = dp[i][j-1];
					dp[i][j] = up+left;
				}
			}
		}
		return dp[m-1][n-1];
	}

}
