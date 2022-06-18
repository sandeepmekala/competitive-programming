package edu.algos.dp1;

public class Dp05HouseRobber {

	public static void main(String[] args) {
		Dp05HouseRobber obj = new Dp05HouseRobber();
		
		int[] nums = new int[] {2,7,9,3,1};
		System.out.println(obj.rob(nums));
	}
	
	/*
	 * Problem: Maximize the house robbery. You can't rob adjacent houses.
	 * Concept: Go left to right by caching the results of smaller problems. If you choose to rob the current house, you need rob remaining nums[i-2] houses, 
	 * if you ignore the current house, you need to rob nums[i-1] houses.
	 *	T[i] = Max{
	 *		profit(i)+T[i-2],
	 *		T[i-1]
	 *	}
	 * 
	 * */
	public int rob(int[] nums) {
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
