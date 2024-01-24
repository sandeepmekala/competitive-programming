package  com.algos.li20_dp;

public class Subsequence_L416_PartitionEqualSubsetSum {

	public static void main(String[] args) {
		Subsequence_L416_PartitionEqualSubsetSum obj = new Subsequence_L416_PartitionEqualSubsetSum();
		
		int[] nums = new int[] {2,4,11,5};
		//int[] nums = new int[] {1,2,5};
		System.out.println(obj.canPartition(nums));
	}

	/*	Problem: https://leetcode.com/problems/partition-equal-subset-sum/
	 *	Idea: Reuse the count subsets log
	// s1 + s2 = totalSum
    // s2 = (totalSum)/2
	 * 
	 * i/j	0	1	2	3	4
	 * 1	t	t	f	f	f
	 * 2	t	t	t	t	t
	 * 5	t	t	t	t	t
	 * 
	 * */
	// Time: O(n*tar)
    // Space: O(n*tar)
	public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int num: nums)
            totalSum += num;
        if(totalSum%2 == 1 || n == 1)
            return false;
        
        int target = totalSum/2;
        return subsetSumToK(nums, n, target);
    }

	private boolean subsetSumToK(int[] nums, int n, int target) {
		boolean[][] sum = new boolean[n][target+1];
		for(int ind=0; ind<n; ind++) {
			for(int tar=0; tar<=target; tar++) {
				if(tar == 0) {
					sum[ind][tar] = true;
				}else if(ind == 0) {
					if(tar == nums[ind]) 
						sum[ind][tar] = true;
				}else {
					boolean notTaken = sum[ind-1][tar];
					boolean taken = false;
					if(nums[ind]<=tar)
						taken = sum[ind-1][tar-nums[ind]];
					sum[ind][tar] = notTaken || taken;
				}
			}
		}
		
		return sum[n-1][target];
	}
}
