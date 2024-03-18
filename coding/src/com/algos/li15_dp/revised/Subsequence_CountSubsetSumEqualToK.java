package  com.algos.li15_dp.revised;

import java.util.Arrays;

public class Subsequence_CountSubsetSumEqualToK {

	public static void main(String[] args) {
		Subsequence_CountSubsetSumEqualToK obj = new Subsequence_CountSubsetSumEqualToK();
		
		int nums[] = {2,4,6,10};
		//int nums[] = {0,0,1};
		int target  = 16;
		System.out.println(obj.findWays(nums, target));
		System.out.println(obj.findWays2(nums, target));
	}
	
    // Problem: https://bit.ly/3B5JBkU
    // Time: O(n*tar)
    // Space: O(n*tar)
	public int findWays(int nums[], int target) {
        int n = nums.length;
        int[][] sum = new int[n][target + 1];
        if (nums[0] == 0)
            sum[0][0] = 2; // 2 cases -pick and not pick
        else
            sum[0][0] = 1; // 1 case - not pick

        if (nums[0] != 0 && nums[0] <= target)
            sum[0][nums[0]] = 1; // 1 case -pick
        for (int ind = 1; ind < n; ind++) {
            for (int tar = 0; tar <= target; tar++) {
                int notPick = sum[ind - 1][tar];
                int pick = 0;
                if (tar - nums[ind] >= 0)
                    pick = sum[ind - 1][tar - nums[ind]];

                sum[ind][tar] = pick + notPick;
            }
        }
        return sum[n - 1][target];
    }

    public int findWays2(int nums[], int target) {
        int n = nums.length;
        int[][] sum = new int[n][target + 1];
        for(int[] row: sum)
            Arrays.fill(row, -1);  

        return findWays(n-1, target, nums, sum);
    }
    int mod = (int) (Math.pow(10, 9) + 7);
    public int findWays(int ind, int target, int[] nums, int[][] sum) {
        if (ind == 0) {
            if (target == 0 && nums[0] == 0)
                return 2;
            if (target == 0 || target == nums[0])
                return 1;
            return 0;
        }

        if (sum[ind][target] != -1)
            return sum[ind][target];

        int notPick = findWays(ind - 1, target, nums, sum);

        int pick = 0;
        if (nums[ind] <= target)
            pick = findWays(ind - 1, target - nums[ind], nums, sum);

        return sum[ind][target] = (notPick + pick) % mod;
    }

}
