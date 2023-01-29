package edu.algos.li20_dp.hard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Partitions_L312_BurstBalloons {

	public static void main(String[] args) {
		Partitions_L312_BurstBalloons obj = new Partitions_L312_BurstBalloons();

		int[] nums = new int[] { 3, 1, 5, 8 };
		System.out.println(obj.maxCoins(nums));
		System.out.println(obj.maxCoins2(nums));
	}

	/*
	 * Problem: https://leetcode.com/problems/burst-balloons/
	 * Idea: We take each position and try to burst the balloons on its left and
	 * right before bursting it.
	 * left sub problem and right sub problems become independent of we include the
	 * current element also in its sub array.
	 * Once left and right sub problems are solved, we are left with bursting last
	 * balloonand last supporting balloons at i-1 and j+1 positions
	 * 
	 */
	public int maxCoins(int[] nums) {
		int n = nums.length;
		List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		list.add(0, 1);
		list.add(1);

		int[][] coins = new int[n + 2][n + 2];
		for(int i=n; i>=1; i--){
			for(int j=1; j<=n; j++){
				if(i>j) continue;

				int max = Integer.MIN_VALUE;
				for (int k = i; k <= j; k++) {
					int coin = list.get(i - 1) * list.get(k) * list.get(j + 1)
							+ coins[i][k - 1]
							+ coins[k + 1][j];
					max = Math.max(max, coin);
				}
				coins[i][j] = max;
			}
		}
		return coins[1][n];
	}

	public int maxCoins2(int[] nums) {
		int n = nums.length;
		List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		list.add(0, 1);
		list.add(1);

		int[][] coins = new int[n + 1][n + 1];
		return maxCoins(list, 1, n, coins);
	}

	private int maxCoins(List<Integer> nums, int i, int j, int[][] mem) {
		if (i > j) 
			return 0;

		int max = 0;
		for (int k = i; k <= j; k++) {
			int coins = nums.get(i - 1) * nums.get(k) * nums.get(j + 1)
					+ maxCoins(nums, i, k - 1, mem)
					+ maxCoins(nums, k + 1, j, mem);
			max = Math.max(max, coins);
		}
		return max;
	}
}
