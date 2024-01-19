package edu.algos.li20_dp;

public class _Grid_TwoStartNMultiEnd_L1463_CherryPickupII {
    public static void main(String args[]){
        _Grid_TwoStartNMultiEnd_L1463_CherryPickupII obj = new _Grid_TwoStartNMultiEnd_L1463_CherryPickupII();

        int[][] grid = new int[][]{
            {3,1,1},
            {2,5,1},
            {1,5,5},
            {2,1,1}};
        System.out.println(obj.cherryPickup(grid));
        System.out.println(obj.cherryPickup2(grid));
    }

    // Problem: https://leetcode.com/problems/cherry-pickup-ii/
    // Idea: Idea is same like fixed start to variable ends. But there are 2 fixed positions and when they overlap, those cells should be counted only once.
    // Hence, we run both robots in the same recursion to eliminate the cases of overlapping. This leads to 3D dp.
    // Time: O(m*n*n*9)
    // Space: O(m*n*n)
    public int cherryPickup(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][][] cost = new int[m][n][n];
        for(int j1=0; j1<n; j1++){
            for(int j2=0; j2<n; j2++){
                if(j1==j2){
                    cost[m-1][j1][j2] = grid[m-1][j1];      // i=m-1
                }else{
                    cost[m-1][j1][j2] = grid[m-1][j1]+grid[m-1][j2];
                }
            }
        }

        for(int i=m-2; i>=0; i--){
            for(int j1=0; j1<n; j1++){
                for(int j2=0; j2<n; j2++){
                    int max = (int)-1e8;
                    for(int dj1=-1; dj1<=1; dj1++){
                        for(int dj2=-1; dj2<=1; dj2++){
                            int value = 0;
                            if(j1==j2){
                                value = grid[i][j1];
                            }else{
                                value = grid[i][j1]+grid[i][j2];
                            }
                            if(j1+dj1>=0 && j1+dj1<n && j2+dj2>=0 && j2+dj2<n)
                                value += cost[i+1][j1+dj1][j2+dj2];
                            else
                                value += (int)-1e8; 
                            max = Math.max(max, value);
                        }
                    }
                    cost[i][j1][j2] = max;
                }
            }
        }

        return cost[0][0][n-1];
    }

    public int cherryPickup2(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        return cherryPickup2(grid, 0, 0, n-1, m, n);
    }

    private int cherryPickup2(int[][] grid, int i, int j1, int j2, int m, int n) {
        if(j1<0 || j2<0 || j1>=n || j2>=n)
            return (int)-1e8;
        if(i==m-1){
            if(j1==j2){
                return grid[i][j1];
            }else{
                return grid[i][j1]+grid[i][j2];
            }
        }

        int max = (int)-1e8;
        for(int dj1=-1; dj1<=1; dj1++){
            for(int dj2=-1; dj2<=1; dj2++){
                int value = 0;
                if(j1==j2){
                    value = grid[i][j1];
                }else{
                    value = (grid[i][j1]+grid[i][j2]);
                }
                value += cherryPickup2(grid, i+1, j1+dj1, j2+dj2, m, n);
                max = Math.max(max, value);
            }
        }
        return max;
    }
}
