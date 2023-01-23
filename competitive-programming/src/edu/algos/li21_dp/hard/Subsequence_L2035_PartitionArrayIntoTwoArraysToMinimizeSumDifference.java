package edu.algos.li21_dp.hard;

import java.util.HashMap;
import java.util.Map;

public class Subsequence_L2035_PartitionArrayIntoTwoArraysToMinimizeSumDifference {
    public static void main(String[] args) {
        Subsequence_L2035_PartitionArrayIntoTwoArraysToMinimizeSumDifference obj = new Subsequence_L2035_PartitionArrayIntoTwoArraysToMinimizeSumDifference();

        int[] nums = new int[]{3,9,7,3};
        System.out.println(obj.minimumDifference(nums));
        System.out.println(obj.minimumDifference2(nums));
    }

    // Problem: https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
    // Idea: Similar logic of subset sum to k. In sums array all the sum values posibility is stored. Use that to find abs min diff sums and min.
    public int minimumDifference(int[] nums) {
        int target = 0, n = nums.length;
        for(int num: nums) target += num;

        boolean[][] sum = new boolean[n][target+1];
		for(int i=0; i<n; i++) {
			for(int j=0; j<=target; j++) {
				if(j == 0) {
					sum[i][j] = true;
				}else if(i == 0) {
					if(j == nums[i]) {
						sum[i][j] = true;
					}
				}else if(nums[i] > j) {
					sum[i][j] = sum[i-1][j];
				}else {
					sum[i][j] = sum[i-1][j] || sum[i-1][j-nums[i]];
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

    // for negative numbers use map
    // TODO
    public int minimumDifference2(int[] nums) {
        int target = 0, n = nums.length;
        for(int num: nums) target += num;

        //boolean[][] sum = new boolean[n][target+1];
        Map<String, Boolean> sum = new HashMap<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<=target; j++) {
				if(j == 0) {
                    sum.put(i+":"+j, true);
				}else if(i == 0) {
					if(j == nums[i]) {
						sum.put(i+":"+j, true);
					}else{
                        sum.put(i+":"+j, false);
                    }
				}else if(nums[i] > j) {
                    sum.put(i+":"+j, sum.get((i-1)+":"+j));
				}else {
                    boolean pick = sum.get((i-1)+":"+(j-nums[i]));
                    boolean notPick = sum.get((i-1)+":"+j);
					sum.put(i+":"+j, pick || notPick);
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
