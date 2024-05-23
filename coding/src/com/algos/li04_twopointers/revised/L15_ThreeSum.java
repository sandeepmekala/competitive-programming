package  com.algos.li04_twopointers.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15_ThreeSum {

	public static void main(String[] args) {
		L15_ThreeSum obj = new L15_ThreeSum();
		System.out.println(obj.threeSum(new int[] { -2,0,0,2,2}));
	}

	// Problem: https://leetcode.com/problems/3sum/
	// Idea: Sort the nums to eleminate the duplicates
	public List<List<Integer>> threeSum(int[] nums) {
		int n = nums.length;
		List<List<Integer>> ans = new ArrayList<>();
		if (n < 3) 
			return ans;
			
		Arrays.sort(nums);
		for (int i = 0; i <= n - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			
			int l = i + 1, r = n - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				if (sum == 0) {
					ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
					l++;
					while(l < r && nums[l] == nums[l-1]) l++;
				} else if (sum > 0) {
					r--;
				} else {
					l++;
				}
			}
		}

		return ans;
	}
}
