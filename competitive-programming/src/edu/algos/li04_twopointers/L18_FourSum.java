package edu.algos.li04_twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L18_FourSum {

	public static void main(String[] args) {
		L18_FourSum obj = new L18_FourSum();
		
		int[] nums = new int[] {1,0,-1,0,-2,2};
		int target = 0;
		System.out.println(obj.fourSum(nums, target));
		
	}
	
    // Problem: https://leetcode.com/problems/4sum/
    // Idea: Sort the nums to eleminate the duplicates
	public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length >= 4) {
            Arrays.sort(nums);
			for (int i = 0; i <= n-4; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                //if((long) nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;
                //if((long) nums[i] + nums[n-3] + nums[n-2] + nums[n-1] < target) continue;
                
                for(int j=i+1; j<=n-3; j++){
                    if (j > i+1 && nums[j] == nums[j - 1]) continue;
                    //if((long) nums[j] + nums[j+1] + nums[j+2] > target - nums[i]) break;
                    //if((long) nums[j] + nums[n-2] + nums[n-1] < target - nums[i]) continue;
                    
                    int twoSumTarget = target - (nums[i] + nums[j]);
                    int left = j + 1, right = n - 1;
                    while (left < right) {
                        if (nums[left] + nums[right] == twoSumTarget) {
                            ArrayList<Integer> list = new ArrayList<Integer>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[left]);
                            list.add(nums[right]);
                            result.add(list);

                            while(left < right && nums[left] == nums[left+1]) left++;
                            while(left < right && nums[right] == nums[right-1]) right--;
                            left++;
                            right--;
                        } else if (nums[left] + nums[right] > twoSumTarget) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                }
			}
		}

		return result;
    }

}
