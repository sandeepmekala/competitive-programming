package edu.algos.dp;

public class Algo100_MatrixPathMinmumCost {

	public static void main(String[] args) {
		int[][] costs = new int[][] {
			{1,3,5,8},
			{4,2,1,7},
			{4,3,2,3}
		};
		System.out.println(minmumCost(costs, costs.length, costs[0].length));
	}

	/*i\j	0	1	2	3	
	 * 	0	1	4	9	17
	 * 	1	5	6	7	14
	 * 	2	9	9	9	12
	 * 
	 * */
	private static int minmumCost(int[][] costs, int m, int n) {
		int mem[][] = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(i == 0 && j == 0) {
					mem[i][j] = 1;
				}else if(i == 0){
					mem[i][j] = mem[i][j-1]+costs[i][j];
				}else if(j == 0){
					mem[i][j] = mem[i-1][j]+costs[i][j];
				}else {
					mem[i][j] = Math.min(mem[i-1][j], mem[i][j-1])+costs[i][j];
				}
			}
		}
		return mem[m-1][n-1];
	}

}
