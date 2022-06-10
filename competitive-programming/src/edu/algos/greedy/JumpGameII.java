package edu.algos.greedy;

public class JumpGameII {

	public static void main(String[] args) {
		JumpGameII obj = new JumpGameII();
		
		System.out.println(obj.jump(new int[] {2,2,0,1,4}));
	}

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
