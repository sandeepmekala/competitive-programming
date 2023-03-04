package edu.algos.li06_binarysearch.hard;

public class L2387_MedianOfARowWiseSortedMatrix {
    public static void main(String args[]) {
        L2387_MedianOfARowWiseSortedMatrix obj = new L2387_MedianOfARowWiseSortedMatrix();

        int row = 3, col = 3;
        int[][] arr = { { 1, 3, 8 },
                { 2, 3, 4 },
                { 1, 2, 5 } };
        System.out.println("The median of the row-wise sorted matrix is: " +
                obj.findMedian(arr, row, col));

    }

    // Problem: https://leetcode.com/problems/median-of-a-row-wise-sorted-matrix/
    // https://www.interviewbit.com/problems/matrix-median/
    public int findMedian(int[][] nums, int row, int col) {
        int low = 1, high = (int)1e9;
        int m = row, n = col;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                cnt += countSmallerThanMid(nums[i], mid, col);
            }
            if (cnt <= (m * n)/2)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    private int countSmallerThanMid(int[] nums, int mid, int n) {
        int l = 0, h = n - 1;
        while (l <= h) {
            int md = (l + h) >> 1;
            if (nums[md] <= mid) {
                l = md + 1;
            } else {
                h = md - 1;
            }
        }
        return l;
    }
}
