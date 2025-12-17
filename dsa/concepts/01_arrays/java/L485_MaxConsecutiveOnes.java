package li01_array.java;

public class L485_MaxConsecutiveOnes {

	public static void main(String[] args) {
		L485_MaxConsecutiveOnes obj = new L485_MaxConsecutiveOnes();

		int[] nums = new int[] {1,1,0,1,1,1};
		System.out.println(obj.findMaxConsecutiveOnes(nums));
	}


	// Problem: https://leetcode.com/problems/max-consecutive-ones/
	// Idea: If num=1 then count++, else reset count=0. track global max.
	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0, count = 0;
		for (int num : nums) {
			if (num == 1) {
				count++;
				max = Math.max(max, count);
			} else {
				count = 0;
			}
		}

		return max;
	}
}
