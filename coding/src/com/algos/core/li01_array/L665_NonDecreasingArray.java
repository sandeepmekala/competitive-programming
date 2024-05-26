package  com.algos.core.li01_array;

public class L665_NonDecreasingArray {

    public static void main(String[] args) {
        L665_NonDecreasingArray obj = new L665_NonDecreasingArray();

        int[] nums = new int[] { 4, 2, 3, 5 };
        System.out.println(obj.checkPossibility(nums));
    }

    /*
     * Problem: https://leetcode.com/problems/non-decreasing-array/
     * Companies: Amazon
     * Idea: Check if non decrease property voilated more then once. Once it is voilated, we need to correct it atleast once to check if it fails again.
     */
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return true;

        boolean nonDecreasing = false;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) { // Non decrease voilation check
                if (nonDecreasing)
                    return false;

                if (i > 0) {
                    if (nums[i - 1] <= nums[i + 1])
                        nums[i] = nums[i + 1];
                    else
                        nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
                nonDecreasing = true;
            }
        }

        return true;
    }
}
