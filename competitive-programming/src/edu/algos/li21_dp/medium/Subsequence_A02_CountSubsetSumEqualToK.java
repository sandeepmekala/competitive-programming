package edu.algos.li21_dp.medium;

public class Subsequence_A02_CountSubsetSumEqualToK {

	public static void main(String[] args) {
		Subsequence_A02_CountSubsetSumEqualToK obj = new Subsequence_A02_CountSubsetSumEqualToK();
		
		int nums[] = {2,4,6,10};
		//int nums[] = {0,0,1};
		int target  = 16;
		System.out.println(obj.findWays(nums, target));
		System.out.println(obj.findWays(nums, target, nums.length-1));
	}
	
	public int findWays(int nums[], int target) {
        int n = nums.length;
        int[][] sum = new int[n][target + 1];
        if (nums[0] == 0)
            sum[0][0] = 2; // 2 cases -pick and not pick
        else
            sum[0][0] = 1; // 1 case - not pick

        if (nums[0] != 0 && nums[0] <= target)
            sum[0][nums[0]] = 1; // 1 case -pick
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int pick = 0;
                if (j - nums[i] >= 0)
                    pick = sum[i - 1][j - nums[i]];

                int notPick = sum[i - 1][j];

                sum[i][j] = pick + notPick;
            }
        }
        return sum[n - 1][target];
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

	// n and sum are defining the state
	// O(n*sum)
	public int findWays(int nums[], int target, int index){
		if(target == 0)
			return 1;
		if(index == 0)
			if(nums[index] == target) return 1;
			else return 0;
		
		int pick = 0;
		if(nums[index] <=  target)
			pick = findWays(nums, target - nums[index], index-1);

		int notPick = findWays(nums, target, index-1);
		
		return pick + notPick;
	}

}
