package edu.algos.li08.greedy;

public class JumpGame {

	public static void main(String[] args) {
		JumpGame obj = new JumpGame();
		
		System.out.println(obj.canJump(new int[] {3,2,1,0,4}));
	}

	public boolean canJump(int[] nums) {
        int i = nums.length-1;
        int j = i-1;
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
