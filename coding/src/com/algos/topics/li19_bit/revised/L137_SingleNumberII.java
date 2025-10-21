package  com.algos.topics.li19_bit.revised;

public class L137_SingleNumberII {
	public static void main(String[] args) {
		L137_SingleNumberII obj = new L137_SingleNumberII();
		int[] numbers = new int[] { 1, 5, 3, 5, 1, 5, 1 };
		System.out.println(obj.singleNumber(numbers));
		System.out.println(obj.singleNumber2(numbers));
	}

	// Problem: https://leetcode.com/problems/single-number-ii/
	// Idea: Count the number of 1's and do %3. It will nullify all the repeating nums leaving the odd bit.
	// Time: O(n), Space: O(1)
	public int singleNumber(int[] nums) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			int bits = 0;
			for (int j = 0; j < nums.length; j++) {
				if (((nums[j] >> i) & 1) == 1)
					bits++;
			}
			if (bits % 3 != 0)
				ans = ans | (1<<i);
		}
		return ans;
	}

	// Idea: num will go to ones if it is not in twos.
	// num will go to twos if it is in ones.
	// num will go to threes if it is in twos.
	public int singleNumber2(int[] nums) {
		int ones = 0, twos = 0;
		for(int num: nums){
			ones = (ones ^ num) & ~twos;
			twos = (twos ^ num) & ~ones;
		}
		return ones;
	}
}
