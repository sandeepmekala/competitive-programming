package edu.algos.dp1;

import java.util.Arrays;

public class Dp05HouseRobberII {

	public static void main(String[] args) {
		Dp05HouseRobberII obj = new Dp05HouseRobberII();
		
		//int[] nums = new int[] {2,3,2};
		int[] nums = new int[] {0,0};
		System.out.println(obj.rob(nums));
	}
	
	/*
	 *	Problem: Same as House Robber problem except houses are in circular order.
	 *  Concept: We can't rob both first and last houses. Hence we slip array in to 2 parts. 
	 *  Once including the first element and another one including last element. 
	 *  Run normal House Robber algo on both arrays and take max.
	 * 
	 * 
	 * */
	public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        
        int[] part1 = Arrays.copyOfRange(nums, 0, n-1);
        int[] part2 = Arrays.copyOfRange(nums, 1, n);
        return Math.max(robHelper(part1), robHelper(part2));
    }
	
	private int robHelper(int[] nums) {
		int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        
		int[] table = new int[n];
        table[0] = nums[0];
        table[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++){
            table[i] = Math.max(nums[i]+table[i-2], table[i-1]);
        }
        
        return table[n-1];
	}

}
