package  com.algos.li05_binarysearch.revised;

public class L2387_MedianOfARowWiseSortedMatrix {
    public static void main(String args[]) {
        L2387_MedianOfARowWiseSortedMatrix obj = new L2387_MedianOfARowWiseSortedMatrix();

        int[][] arr = { { 1, 3, 8 },    // 1,1,2,2,3,3,4,5,8
                { 2, 3, 4 },
                { 1, 2, 5 } };
        System.out.println("The median of the row-wise sorted matrix is: " +
                obj.findMedian(arr));

    }

    // Problem: https://leetcode.com/problems/median-of-a-row-wise-sorted-matrix/
    // https://www.interviewbit.com/problems/matrix-median/
    // Time: O(32 * r * log(c))
    // Idea: Binary search on the range of numbers in the matrix to find the median of the matrix using binary search on every row to find the total count of numbers smaller or equal than the mid.
    public int findMedian(int[][] nums) {
        int low = 1, high = (int)1e9;
        int row = nums.length, col = nums[0].length;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 0;
            for (int i = 0; i < row; i++) {
                cnt += countSmallerThanMid(nums[i], mid);
            }
            if (cnt <= (row * col)/2)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    private int countSmallerThanMid(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int md = (low + high) / 2;
            if (nums[md] <= target) {
                low = md + 1;
            } else {
                high = md - 1;
            }
        }
        return low;
    }
}
