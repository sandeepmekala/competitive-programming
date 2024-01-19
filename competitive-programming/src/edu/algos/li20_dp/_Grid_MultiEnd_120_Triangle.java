package edu.algos.li20_dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _Grid_MultiEnd_120_Triangle {
    public static void main(String args[]){
        _Grid_MultiEnd_120_Triangle obj = new _Grid_MultiEnd_120_Triangle();

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3,4)));
        triangle.add(new ArrayList<>(Arrays.asList(6,5,7)));
        triangle.add(new ArrayList<>(Arrays.asList(4,1,8,3)));

        System.out.println(obj.minimumTotal(triangle));

        int m=triangle.size();
        System.out.println(obj.minimumTotal(triangle, 0, 0, m));
    }

    // Problem: https://leetcode.com/problems/triangle/
    // Idea: As the target is anything in last row, we can't start recursion from end. Hence, we start recursions from fixed start point.
    // Time: O(m*n)
    // Space: O(m*n)
    public int minimumTotal(List<List<Integer>> triangle, int i, int j, int m) {   
        if(i==m-1)
            return triangle.get(i).get(j);
        
        int  down = triangle.get(i).get(j) + minimumTotal(triangle, i+1, j, m);
        int  diagonal = triangle.get(i).get(j) + minimumTotal(triangle, i+1, j+1, m);

        return Math.min(down, diagonal);
    }

    public int minimumTotal(List<List<Integer>> triangle) { 
        int m=triangle.size();

        int[][] cost = new int[m][m];
        for(int j=m-1; j>=0; j--){
            cost[m-1][j] = triangle.get(m-1).get(j);
        }
        for(int i=m-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                int down = triangle.get(i).get(j)+cost[i+1][j];
                int diagonal = triangle.get(i).get(j)+cost[i+1][j+1];
                cost[i][j] = Math.min(down, diagonal);
            }
        }
        return cost[0][0];
    }
}
