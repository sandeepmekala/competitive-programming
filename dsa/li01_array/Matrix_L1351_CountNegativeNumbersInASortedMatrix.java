
public class Matrix_L1351_CountNegativeNumbersInASortedMatrix {

	public static void main(String[] args) {
		Matrix_L1351_CountNegativeNumbersInASortedMatrix obj = new Matrix_L1351_CountNegativeNumbersInASortedMatrix();

		int[][] grid = new int[][]{
			{4,3,2,-1},
			{3,2,1,-1},
			{1,1,-1,-2},
			{-1,-1,-2,-3}};

		System.out.println(obj.countNegatives(grid));
	}

	/*
	 * Problem: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
	 * Idea: Start at the top-right and count the negatives in each column. You can even start at bottom-left.
	 *
	 * */
	public int countNegatives(int[][] grid) {
        int count = 0, m=grid.length, n=grid[0].length;
        int i=0, j=n-1;
        while(i<m && j>=0){
            if(grid[i][j] < 0){
                count += (m-i);
                j--;
            }else{
                i++;
            }
        }

        return count;
    }
}
