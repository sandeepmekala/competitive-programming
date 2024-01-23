package  com.algos.li20_dp;

import java.util.Arrays;

public class _Lis_L45_JumpGameII {

	public static void main(String[] args) {
		_Lis_L45_JumpGameII obj = new _Lis_L45_JumpGameII();
		
		int[] jumps = new int[] {2,3,1,1,2,4,2,0,1,1};
		System.out.println(obj.jump(jumps));
	}
	
	/*
	* Idea: If i is reachable from j, minj[i] = min(minj[i], minj[j]+1)
	* 
	* 	i		2	3	1	1	2	4	2	0	1	1
	* 	minj	0	1	1	2	2	3	3	4	4	4
	* 	path	0	0	0	1	1	4	4	5	5	5	
	* */
	public int jump(int[] nums) {
		int n = nums.length;
		if(n == 1)
		    return 0;
		if(nums[0] == 0) 
			return -1;
		
		int[] jumps = new int[n];
		Arrays.fill(jumps, Integer.MAX_VALUE);
		jumps[0] = 0;
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(j+nums[j] >= i) {
					jumps[i] = Math.min(jumps[i], jumps[j]+1);
				}
			}
		}
		//System.out.println(Arrays.toString(minj));
		if(jumps[n-1] == Integer.MAX_VALUE) 
			return -1;
		return jumps[n-1];
	}

	// Greedy
	// Problem: https://leetcode.com/problems/jump-game-ii/
    // Idea: Move left to right and jump to longest position in every iteration. Find longest position for next interation in every iteration.
	public int jump2(int[] nums) {
        int count = 0;
        int i = 0, j = 0;
        while(j<nums.length-1){
            int longest = 0;
            for(int k=i; k<=j; k++){
                longest = Math.max(longest, k+nums[k]);
            }
            i = j+1;
            j = longest;
            count++;
        }
        return count;
    }

}
