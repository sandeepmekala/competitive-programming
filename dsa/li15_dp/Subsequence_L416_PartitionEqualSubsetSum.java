
public class Subsequence_L416_PartitionEqualSubsetSum {

	public static void main(String[] args) {
		Subsequence_L416_PartitionEqualSubsetSum obj = new Subsequence_L416_PartitionEqualSubsetSum();

		int[] nums = new int[] {2,4,11,5};
		//int[] nums = new int[] {1,2,5};
		System.out.println(obj.canPartition(nums));
	}

	// Problem: https://leetcode.com/problems/partition-equal-subset-sum/
	// Idea: Subset Sum Equals to Target
	// s1 + s2 = totalSum
    // s2 = (totalSum)/2    as s1=s2
	//
	// i/j	0	1	2	3	4
	// 1	t	t	f	f	f
	// 2	t	t	t	t	t
	// 5	t	t	t	t	t
	//
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
		boolean[][] dp = new boolean[n][target+1];
		for(int ind=0; ind<n; ind++) {
			for(int tar=0; tar<=target; tar++) {
				if(tar == 0) {
					dp[ind][tar] = true;
				}else if(ind == 0) {
					if(tar == nums[ind])
						dp[ind][tar] = true;
				}else {
					boolean notPick = dp[ind-1][tar];
					boolean pick = false;
					if(nums[ind]<=tar)
						pick = dp[ind-1][tar-nums[ind]];
					dp[ind][tar] = notPick || pick;
				}
			}
		}

		return dp[n-1][target];
	}
}
