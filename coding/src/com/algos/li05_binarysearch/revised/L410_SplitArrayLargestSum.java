package  com.algos.li05_binarysearch.revised;

public class L410_SplitArrayLargestSum {
    public static void main(String args[]) {
        L410_SplitArrayLargestSum obj = new L410_SplitArrayLargestSum();

        int[] nums = new int[]{7,2,5,10,8};
        int students = 2;
        System.out.println(obj.splitArray(nums, students));
    }

    // Problem: https://leetcode.com/problems/split-array-largest-sum/
    // Idea: Binary search on the range of pages 
    // Same as Allocation of minimum number of pages problem
    public int splitArray(int[] nums, int k) {
        if (k > nums.length)
            return -1;

        int low = nums[0];
        int high = 0;
        for (int i = 0; i < nums.length; i++) {
            low = Math.min(low, nums[i]);
            high = high + nums[i];
        }
        int res = -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (isPossible(nums, mid, k)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    boolean isPossible(int[] nums, int maxAllocation, int noOfStuds) {
        int allocateStuds = 1;
        int sumAllocated = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sumAllocated + nums[i] > maxAllocation) {
                allocateStuds++;
                sumAllocated = nums[i];
                if (sumAllocated > maxAllocation)
                    return false;
            } else {
                sumAllocated += nums[i];
            }
        }
        return allocateStuds <= noOfStuds;
    }
}
