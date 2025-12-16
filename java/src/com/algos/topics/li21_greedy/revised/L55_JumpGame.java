package  com.algos.topics.li21_greedy.revised;

public class L55_JumpGame {

	public static void main(String[] args) {
		L55_JumpGame obj = new L55_JumpGame();

		System.out.println(obj.canJump(new int[] {3,2,1,0,4}));
	}

    // Problem: https://leetcode.com/problems/jump-game/
    // Idea: For every position check what is max index it can reach.
    // If at any point, current position is greater than max index, return false.
	public boolean canJump(int[] nums) {
        int n = nums.length;

        int longest = 0;
        for(int i=0; i<n; i++){
            if(i > longest)
                return false;
            longest = Math.max(longest, i+nums[i]);
        }

        return true;
    }
}
