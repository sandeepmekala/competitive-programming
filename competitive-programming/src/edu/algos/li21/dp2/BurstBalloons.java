package edu.algos.li21.dp2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BurstBalloons {

	public static void main(String[] args) {
		BurstBalloons obj = new BurstBalloons();

		int[] nums = new int[] { 3, 1, 5, 8 };
		System.out.println(obj.maxCoins(nums));
	}

	/*
	 * Problem: https://leetcode.com/problems/burst-balloons/
	 * Concept: We take each position and try to burst the balloons on its left and right before bursting it.
	 * left sub problem and right sub problems become independent of we include the current element also in its sub array.
	 * Once left and right sub problems are solved, we are left with bursting last balloonand last supporting balloons at l-1 and r+1 positions
	 * 
	 * */
	public int maxCoins(int[] nums) {
		 	int n = nums.length;
	        List<Integer> list  = Arrays.stream(nums).boxed().collect(Collectors.toList());
	        list.add(0, 1);
	        list.add(1);
	        
	        int[][] mem = new int[n+1][n+1];
	        return maxCoinsRec(list, 1, list.size()-2, mem);
	    }

	private int maxCoinsRec(List<Integer> nums, int l, int r, int[][] mem) {
		if (l > r) {
			return 0;
		}
		if(mem[l][r] != 0) {
			return mem[l][r];
		}
		
		int max = 0;
		for (int i = l; i <= r; i++) {
			int coins = nums.get(l - 1) * nums.get(i) * nums.get(r + 1) 
					+ maxCoinsRec(nums, l, i - 1, mem)
					+ maxCoinsRec(nums, i + 1, r, mem);
			max = Math.max(max, coins);
		}
		mem[l][r] = max;
		return mem[l][r];
	}
}
