import java.util.Arrays;

public class L628_MaximumProductOfThreeNumbers {

	public static void main(String[] args) {
		L628_MaximumProductOfThreeNumbers obj = new L628_MaximumProductOfThreeNumbers();

		int[] nums = new int[] {1,2,3,4};
		System.out.println(obj.maximumProduct(nums));
	}

	/*
	 * Problem: https://leetcode.com/problems/maximum-product-of-three-numbers/
	 * Idea: Find max1,2,3 and min1,2 and calculation product.
	 * */
	public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }

	public int maximumProduct2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[n-1], nums[n-3]*nums[n-2]*nums[n-1]);
    }

}
