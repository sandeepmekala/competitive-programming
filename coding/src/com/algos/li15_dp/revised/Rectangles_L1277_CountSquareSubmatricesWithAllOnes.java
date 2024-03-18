package  com.algos.li15_dp.revised;

public class Rectangles_L1277_CountSquareSubmatricesWithAllOnes {
    public static void main(String[] args) {
        Rectangles_L1277_CountSquareSubmatricesWithAllOnes obj = new Rectangles_L1277_CountSquareSubmatricesWithAllOnes();

        int[][] matrix = new int[][]{
            {1,0,1},
            {1,1,0},
            {1,1,0}
          };
          System.out.println(obj.countSquares(matrix));
    }

    // Problem: https://leetcode.com/problems/count-square-submatrices-with-all-ones/
    // Idea: We store the count of squares in each cell and sum them up.
    // We take the min of all the 3 sorrounding cells and add one. This boost the count if all the 3 cells are 1's. 
    // Similarly, if all the 3 cells are 2 it boosts it to 3.
    public int countSquares(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int[][] count = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 1){
                    if(i == 0 || j == 0){
                        count[i][j] = 1;
                    }else{
                        count[i][j] = 1+Math.min(count[i-1][j-1],
                     Math.min(count[i-1][j], count[i][j-1]));
                    }
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                cnt += count[i][j];
            }
        }
        return cnt;
    }
}
