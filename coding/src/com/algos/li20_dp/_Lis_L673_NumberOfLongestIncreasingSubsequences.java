package  com.algos.li20_dp;

import java.util.Arrays;

public class _Lis_L673_NumberOfLongestIncreasingSubsequences {
    public static void main(String[] args) {
        _Lis_L673_NumberOfLongestIncreasingSubsequences obj = new _Lis_L673_NumberOfLongestIncreasingSubsequences();

        int[] nums = new int[]{1,3,5,4,7};
        System.out.println(obj.findNumberOfLIS(nums));
    }

    // Problem: https://leetcode.com/problems/number-of-longest-increasing-subsequence/
    // Idea: With lis array, we need to have a cnt array also. 
    // When you find a j which update i lis, we need to copy j's count as number of ways as sequence can be formed with i is number of ways sequnce is form till j.
    // Once you find another j which form same cnt of i, we need to add cnt of it to the cnt of i as the similar length sequences can be formed with that j also.
    public int findNumberOfLIS(int[] nums) {
        int max = 0, n = nums.length;
        if(n == 1)
            return 1;
		
		int[] lis = new int[n];
		Arrays.fill(lis, 1);	//lis for each element is itself
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(nums[j] < nums[i]) {
                    if(1 + lis[j] > lis[i]){
                        lis[i] = 1 + lis[j];
                        cnt[i] = cnt[j];
                    }else if(1 + lis[j] == lis[i]){
                        cnt[i] += cnt[j];
                    }
				}
			}
			
			if(lis[i] > max) {	//just track max to return
				max = lis[i];
			}
		}

        int count = 0;
        for(int i=0; i<n; i++){
            if(lis[i] == max){
                count += cnt[i];
            }
        }
		return count;
    }
}
