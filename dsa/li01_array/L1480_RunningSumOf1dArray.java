
import java.util.Arrays;

public class L1480_RunningSumOf1dArray {

	public static void main(String[] args) {
		L1480_RunningSumOf1dArray obj = new L1480_RunningSumOf1dArray();

		int[] nums = new int[] {1,2,3,4,5};
		System.out.println(Arrays.toString(obj.runningSum(nums)));
	}

	/*
	 * Problem: https://leetcode.com/problems/running-sum-of-1d-array/
	 * Idea: Trakc prefixSum;
	 * */
	public int[] runningSum(int[] nums) {
        int prefixSum = 0;
        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];
            nums[i] = prefixSum;
        }

        return nums;
    }

}
