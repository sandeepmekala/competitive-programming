package  com.algos.core.li01_array.revised;

public class L152_MaximumProductOfSubArray_Kadanes {

	public static void main(String[] args) {
		L152_MaximumProductOfSubArray_Kadanes obj = new L152_MaximumProductOfSubArray_Kadanes();
		System.out.println(obj.maxProduct(new int[] {-2,-3,-2,-4}));
		System.out.println(obj.maxProduct2(new int[] {-2,-3,-2,-4}));
	}

	// Problem: https://leetcode.com/problems/maximum-product-subarray/
	// Idea: If array has only positive numbers, then max product will be product of all numbers.
	// If array has event number of negative numbers, then max product will be product of all numbers.
	// If array has odd number of negative numbers, then max product will be product of all numbers except one negative number.
	// If we don't consider that neg num, then array will have even number of negative numbers and array will split as two sub arrays.
	// Either prefix product or suffix product will be max product.
	// Zeros also split the array. Hence, when we see 0, we will new sub array. Max will be calculated in each sub array.
	public int maxProduct(int[] nums) {
		int n = nums.length;
		int max = Integer.MIN_VALUE;
		long prefixProd = 1;
		for(int i=0; i<n; i++) {
			prefixProd *= nums[i];
			max = Math.max(max, (int)prefixProd);
			if(prefixProd == 0)
				prefixProd = 1;
		}

		long suffixProd = 1;
		for(int i=n-1; i>=0; i--) {
			suffixProd *= nums[i];
			max = Math.max(max, (int)suffixProd);
			if(suffixProd == 0)
				suffixProd = 1;
		}

		return max;
	}	
	
	// Idea: Use Kadances algo. 
	// Product of two negative nums can become max. Hence, we need track negative max also as it might get multiplied by a negative num.
	// We might form big negative number by multiplying the current max prod with a negative number.
	public int maxProduct2(int[] nums) {
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
