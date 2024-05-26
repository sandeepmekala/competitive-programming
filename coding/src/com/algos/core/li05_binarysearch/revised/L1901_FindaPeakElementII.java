package com.algos.core.li05_binarysearch.revised;

public class L1901_FindaPeakElementII {
        
        public static void main(String[] args) {
            L1901_FindaPeakElementII obj = new L1901_FindaPeakElementII();
            int[][] nums = {
                    {1,4},
                    {3,2}
            };
            int[] res = obj.findPeakGrid(nums);
            System.out.println(res[0] + " " + res[1]);
        }
        
        // Problem: https://leetcode.com/problems/find-a-peak-element-ii/
        // Idea: Start from mid column, find max in that column, then move to left or right based on max
        // Search space range is 0 to n-1
        // Time: O(mlogn)
        public int[] findPeakGrid(int[][] mat) {
            int row = mat.length, col = mat[0].length;
            
            int low = 0, high = col-1;
            while(low <= high){
                int mid = (low+high)/2;
                int maxRow = findRowOfMaxInColumn(mat, mid);    
                int left = mid > 0 ? mat[maxRow][mid-1] : Integer.MIN_VALUE;
                int right = mid < col-1 ? mat[maxRow][mid+1] : Integer.MIN_VALUE;
                if(mat[maxRow][mid] > left && mat[maxRow][mid] > right)
                    return new int[]{maxRow, mid};          
                if(mat[maxRow][mid] < left){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }
            
            return new int[]{-1, -1};
        }

        private int findRowOfMaxInColumn(int[][] mat, int mid) {
            int max = -1;
            int maxRow = -1;
            int m = mat.length;
            for(int i=0; i<m; i++){
                if(mat[i][mid] > max){
                    max = mat[i][mid];
                    maxRow = i;
                }
            }
            return maxRow;
        }
}
