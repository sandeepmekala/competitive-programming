package edu.algos.li01.array;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		MaxConsecutiveOnes obj = new MaxConsecutiveOnes();

		int[] nums = new int[] {1,1,0,1,1,1};
		System.out.println(obj.findMaxConsecutiveOnes(nums));
	}

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
