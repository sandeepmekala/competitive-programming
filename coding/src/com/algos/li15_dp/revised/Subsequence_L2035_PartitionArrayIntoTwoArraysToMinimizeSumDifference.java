package  com.algos.li15_dp.revised;

import java.util.HashMap;
import java.util.Map;

public class Subsequence_L2035_PartitionArrayIntoTwoArraysToMinimizeSumDifference {
    public static void main(String[] args) {
        Subsequence_L2035_PartitionArrayIntoTwoArraysToMinimizeSumDifference obj = new Subsequence_L2035_PartitionArrayIntoTwoArraysToMinimizeSumDifference();

        //int[] nums = new int[]{3,9,7,3};
        int[] nums = new int[]{2,-1,0,4,-2,-9};   
        //System.out.println(obj.minimumDifference(nums));
        System.out.println(obj.minimumDifference2(nums));
    }

    // Problem: https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
    // Idea: Similar logic of subset sum to k. Target will be total sum. 
    // In sums array last row, all the posibile sum values starting from 0 to total sum result is stored. 
    // Use that to find abs min diff sums and min.
    // for negative numbers use map
    // Time: O(n*tar)
    // Space: O(n*tar)
    public int minimumDifference(int[] nums) {
        int target = 0, n = nums.length;
        for(int num: nums) 
            target += num;

        boolean[][] sum = new boolean[n][target+1];
		for(int ind=0; ind<n; ind++) {
			for(int tar=0; tar<=target; tar++) {
				if(tar == 0) {
					sum[ind][tar] = true;
				}else if(ind == 0) {
					if(tar == nums[ind]) 
						sum[ind][tar] = true;
				}else {
					boolean notPick = sum[ind-1][tar];
					boolean pick = false;
					if(nums[ind]<=tar)
						pick = sum[ind-1][tar-nums[ind]];
					sum[ind][tar] = notPick || pick;
				}
			}
		}

        int min = (int) 1e9;
        for(int s1=0; s1<target/2; s1++){
            if(sum[n-1][s1]){
                int s2 = target-s1;
                min = Math.min(min, Math.abs(s2-s1));
            }
        }
        return min;
    }

    
    public int minimumDifference2(int[] nums) {
        int target = 0, n = nums.length;
        for(int num: nums) target += num;

        Map<String, Boolean> sum = new HashMap<>();
		for(int ind=0; ind<n; ind++) {
			for(int tar=0; tar<=target; tar++) {
                sum.put(ind+":"+tar, false);
				if(tar == 0) {
                    sum.put(ind+":"+tar, true);
				}else if(ind == 0) {
					if(tar == nums[ind]) 
						sum.put(ind+":"+tar, true);
				}else {
                    boolean notPick = sum.get(ind-1+":"+tar);
                    boolean pick = false;
                    if(nums[ind]<=tar)
                        pick = sum.get((ind-1)+":"+(tar-nums[ind]));
                    sum.put(ind+":"+tar, notPick || pick);
				}
			}
		}

        int min = (int) 1e9; // fix this for negative nums
        for(int s1=0; s1<target/2; s1++){
            if(sum.get((n-1)+":"+s1)){
                int s2 = target-s1;
                min = Math.min(min, Math.abs(s2-s1));
            }
        }
        return min;
    }
}
