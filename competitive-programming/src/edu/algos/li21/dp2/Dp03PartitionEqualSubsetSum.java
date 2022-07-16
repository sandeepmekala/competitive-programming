package edu.algos.li21.dp2;

public class Dp03PartitionEqualSubsetSum {

	public static void main(String[] args) {
		Dp03PartitionEqualSubsetSum obj = new Dp03PartitionEqualSubsetSum();
		
		int[] nums = new int[] {2,4,11,5};
		//int[] nums = new int[] {1,2,5};
		System.out.println(obj.canPartition(nums));
	}

	/*
	 * i/j	0	1	2	3	4
	 * 1	t	t	f	f	f
	 * 2	t	t	t	t	t
	 * 5	t	t	t	t	t
	 * 
	 * */
	public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum%2 != 0 || n == 1){
            return false;
        }
        
        sum = sum/2;
        boolean[][] mem = new boolean[n][sum+1];
		for(int i=0; i<n; i++) {
			for(int j=0; j<=sum; j++) {
				if(j == 0) {
					mem[i][j] = true;
				}else if(i == 0) {
					if(j == nums[i]) {
						mem[i][j] = true;
					}
				}else if(nums[i] > j) {
					mem[i][j] = mem[i-1][j];
				}else {
					mem[i][j] = mem[i-1][j] || mem[i-1][j-nums[i]];
				}
			}
		}
		
		return mem[n-1][sum];
    }
}
