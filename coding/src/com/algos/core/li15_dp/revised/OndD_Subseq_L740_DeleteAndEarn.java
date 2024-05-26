package  com.algos.core.li15_dp.revised;

import java.util.HashMap;

public class OndD_Subseq_L740_DeleteAndEarn {

	public static void main(String[] args) {
		OndD_Subseq_L740_DeleteAndEarn obj = new OndD_Subseq_L740_DeleteAndEarn();
		
		int[] nums = new int[] {2,2,3,3,3,4};
		System.out.println(obj.deleteAndEarn(nums));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/delete-and-earn/
	 * Companies: Amazon
     * Idea: It is similar to House robber. All the adjacend nums can be treated as adjacent houses.
     * If a num is picked, all it repeats should be summed and that is the profit. Hence we track all the sums in a map.
     * To get all nums in adjacent order, we get the max of nums, loop till max.
     * While looping till max, apply House robber algo on adjacent nums.
	 * */
    // Time: O(max)
	// Space: O(max)
	public int deleteAndEarn(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            max = Math.max(max, num);
            map.put(num, map.getOrDefault(num, 0)+num);
        }
        
        int[] earn = new int[max+1];
        earn[1] =  map.getOrDefault(1, 0);      // only one house is there
        for(int i=2; i<=max; i++){
            int notTake = earn[i-1];
            int take = map.getOrDefault(i, 0) + earn[i-2];
            earn[i] = Math.max(take, notTake);
        }
        
        return earn[max];
    }

}
