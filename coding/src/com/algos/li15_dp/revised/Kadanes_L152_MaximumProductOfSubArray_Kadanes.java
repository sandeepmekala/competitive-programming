package  com.algos.li03_slidingwindow;

public class Kadanes_L152_MaximumProductOfSubArray_Kadanes {

	public static void main(String[] args) {
		Kadanes_L152_MaximumProductOfSubArray_Kadanes obj = new Kadanes_L152_MaximumProductOfSubArray_Kadanes();
		System.out.println(obj.maxProduct(new int[] {-2,-3,-2,-4}));
	}

	// Problem: https://leetcode.com/problems/maximum-product-subarray/
	// Idea: Use Kadances algo. 
	// Product of two negative nums can become max. Hence, we need track negative max also as it might get multiplied by a negative num.
	// We might form big negative number by multiplying the current max prod with a negative number.
	public int maxProduct(int[] nums) {
		int max = nums[0];
		int currMax = nums[0];
		int currMin = nums[0];
		for(int i=1; i<nums.length; i++) {
			int oldMax = currMax;
			currMax = Math.max(nums[i], Math.max(currMax*nums[i], currMin*nums[i]));	//[-1, 8]
			currMin = Math.min(nums[i], Math.min(oldMax*nums[i], currMin*nums[i]));		//[-1, -8]
			
			if(currMax > max)
				max = currMax;
		}

		return max;
    }

}
