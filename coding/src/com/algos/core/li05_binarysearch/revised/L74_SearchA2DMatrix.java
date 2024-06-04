package com.algos.core.li05_binarysearch.revised;

public class L74_SearchA2DMatrix {

    public static void main(String[] args) {
        L74_SearchA2DMatrix obj = new L74_SearchA2DMatrix();
        int[][] matrix = new int[][] {
                        {1,3,5,7},
                        {10,11,16,20},
                        {23,30,34,60}
                    };

        System.out.println(obj.searchMatrix(matrix, 5));
    }

    // Problem: https://leetcode.com/problems/search-a-2d-matrix/
    // Idea: Each row and columns are in increasing order and first element of next
    // row is greater then last element of curr row.
    // For this case optimal approach is to apply BS on range 0 to n*m-1 as the
    // elments are continueously increasing from 0 to n*m-1.
    public boolean searchMatrix(int[][] mat, int target) {
        int m = mat.length, n = mat[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / n, col = mid % n;
            if (mat[row][col] == target) {
                return true;
            } else if (target > mat[row][col]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
