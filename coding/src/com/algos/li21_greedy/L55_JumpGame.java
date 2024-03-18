package  com.algos.li21_greedy;

public class L55_JumpGame {

	public static void main(String[] args) {
		L55_JumpGame obj = new L55_JumpGame();
		
		System.out.println(obj.canJump(new int[] {3,2,1,0,4}));
	}

    // Problem: https://leetcode.com/problems/jump-game/
    // Idea: Move right to left. Continuously move the gole post to left if the goal post is reachable.
	public boolean canJump(int[] nums) {
        int i = nums.length-1, j = i-1;
        while(i >= 0 && j >= 0){
            if(j+nums[j] >= i){
                i = j;
            }
            j--;
        }
        if(i == 0){
            return true;
        }
        return false;
    }
}
