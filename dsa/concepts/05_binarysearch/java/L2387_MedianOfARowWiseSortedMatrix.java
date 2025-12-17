
public class L2387_MedianOfARowWiseSortedMatrix {
    public static void main(String[] args) {
        L2387_MedianOfARowWiseSortedMatrix obj = new L2387_MedianOfARowWiseSortedMatrix();

        int[][] arr = { { 1, 3, 8 },    // 1,1,2,2,3,3,4,5,8
                        { 2, 3, 4 },
                        { 1, 2, 5 } };
        System.out.println(obj.findMedian(arr));

    }

    // Problem: https://leetcode.ca/2022-10-06-2387-Median-of-a-Row-Wise-Sorted-Matrix/
    // Idea: BS range is min and max of matrix elements
    // Find the mid of min and max and count number of elements smaller than or equal mid
    // Time: O(32 * r * log(c))
    public int findMedian(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][col - 1]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = smallerThenOrEqualMid(mat, row, mid);
            if (cnt <= (row * col)/2)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    private int smallerThenOrEqualMid(int[][] mat, int row, int mid) {
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            cnt += upperBound(mat[i], mid);
        }
        return cnt;
    }

    private int upperBound(int[] nums, int target) {
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
