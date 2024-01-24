package  com.algos.li20_dp;

import java.util.HashMap;

public class OndD_Fib_L740_DeleteAndEarn {

	public static void main(String[] args) {
		OndD_Fib_L740_DeleteAndEarn obj = new OndD_Fib_L740_DeleteAndEarn();
		
		int[] nums = new int[] {2,2,3,3,3,4};
		System.out.println(obj.deleteAndEarn(nums));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/delete-and-earn/
	 * Companies: Amazon
     * Idea: It is similar to House robber. All the adjacend nums can be treated as adjacent houses.
     * If a num is picked all it repeats should be summed and that is the profit. Hence we track all the sums in a map.
     * To get all nums in adjacent order, we get the max of nums, loop till max.
     * While looping till max, apply House robber algo on adjacent nums.
	 * */
    // Time: O(max)
	// Space: O(max)
	public int deleteAndEarn(int[] nums) {
        int maxNum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            maxNum = Math.max(maxNum, num);
            map.put(num, map.getOrDefault(num, 0)+num);
        }
        
        int[] earn = new int[maxNum+1];
        earn[1] =  map.getOrDefault(1, 0);
        for(int i=2; i<=maxNum; i++){
            int notTake = earn[i-1];
            int take = map.getOrDefault(i, 0) + earn[i-2];
            earn[i] = Math.max(take, notTake);
        }
        
        return earn[maxNum];
    }

}
