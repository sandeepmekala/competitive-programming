package edu.algos.li21_dp.easy;

public class OneD_Fib_L70_ClimbingStairs {

	public static void main(String[] args) {
		OneD_Fib_L70_ClimbingStairs obj = new OneD_Fib_L70_ClimbingStairs();
		System.out.println(obj.climbStairs(3));
		System.out.println(obj.stairchasesXBottomUp(4, new int[] { 1, 3, 5 }));
	}

	// Problem: https://leetcode.com/problems/climbing-stairs/
	// Idea: The nth stair you can reach from n-1 or n-2 stair. 
	// So take the number of ways to reach n-1 and n-2 stairs. This recursively goes till base case for n-1 and n-2 cases.
	// time: O(n)
	public int climbStairs(int n) {
		int numberOfWays[] = new int[n + 1];
		numberOfWays[0] = 1; // we need only last two numbers in array. So, we can save some space by using two variables instead of array
		numberOfWays[1] = 1;
		for (int i = 2; i <= n; i++) {
			numberOfWays[i] = numberOfWays[i - 1] + numberOfWays[i - 2];
		}
		return numberOfWays[n];
	}

	private int stairchasesXBottomUp(int n, int x[]) {
		int numberOfWays[] = new int[n + 1];
		numberOfWays[0] = 1; // we need only last two numbers in array. So, we can save some space by using
								// two varibles instead of array

		for (int i = 1; i <= n; i++) {
			int total = 0;
			for (int j = 0; j < x.length; j++) {
				if (i - x[j] >= 0) {
					total += numberOfWays[i - x[j]];
				}
			}
			numberOfWays[i] = total;
		}
		return numberOfWays[n];
	}
}
