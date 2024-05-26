package  com.algos.core.li21_greedy.revised;

import java.util.Arrays;

public class L45_JumpGameII {

	public static void main(String[] args) {
		L45_JumpGameII obj = new L45_JumpGameII();
		
		int[] jumps = new int[] {2,3,1,1,2,4,2,0,1,1};
		System.out.println(obj.jump(jumps));
	}

	// Greedy
	// Problem: https://leetcode.com/problems/jump-game-ii/
    // Idea: Every iteration, we find the range of positions we can reach from current position.
	// Calculate next range of positions we can reach from the positions in the current range.
	public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0, l = 0, r = 0;
		while(r<n-1){
            int longest = 0;
            for(int k=l; k<=r; k++){
                longest = Math.max(longest, k+nums[k]);
            }
            l = r+1;
            r = longest;
            jumps++;
        }
        return jumps;
    }

		// Idea: If i is reachable from j, minj[i] = min(minj[i], minj[j]+1)
	// 
	// 	i		2	3	1	1	2	4	2	0	1	1
	// 	minj	0	1	1	2	2	3	3	4	4	4
	// 	path	0	0	0	1	1	4	4	5	5	5	
	public int jump2(int[] nums) {
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
		if(jumps[n-1] == Integer.MAX_VALUE) 
			return -1;
		return jumps[n-1];
	}
}
