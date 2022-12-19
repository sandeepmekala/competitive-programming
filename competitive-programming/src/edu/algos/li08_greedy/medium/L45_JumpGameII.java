package edu.algos.li08_greedy.medium;

public class L45_JumpGameII {

	public static void main(String[] args) {
		L45_JumpGameII obj = new L45_JumpGameII();
		
		System.out.println(obj.jump(new int[] {2,2,0,1,4}));
	}

    // Problem: https://leetcode.com/problems/jump-game-ii/
    // Idea: Move left to right and jump to longest position in every iteration. Find longest position for next interation in every iteration.
	public int jump(int[] nums) {
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
