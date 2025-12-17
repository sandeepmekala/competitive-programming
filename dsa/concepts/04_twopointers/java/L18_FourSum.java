
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L18_FourSum {

	public static void main(String[] args) {
		L18_FourSum obj = new L18_FourSum();

		int[] nums = new int[] {1,0,-1,0,-2,2};
		int target = 0;
		System.out.println(obj.fourSum(nums, target));

	}

    // Problem: https://leetcode.com/problems/4sum/
    // Idea: Sort the nums to eleminate the duplicates
	public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
		if (nums.length < 4)
            return ans;

        Arrays.sort(nums);
        for (int i = 0; i <= n-4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //if((long) nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;
            //if((long) nums[i] + nums[n-3] + nums[n-2] + nums[n-1] < target) continue;

            for(int j=i+1; j<=n-3; j++){
                if (j > i+1 && nums[j] == nums[j - 1]) continue;
                //if((long) nums[j] + nums[j+1] + nums[j+2] > target - nums[i]) break;
                //if((long) nums[j] + nums[n-2] + nums[n-1] < target - nums[i]) continue;

                int twoSumTarget = target - (nums[i] + nums[j]);
                int l = j + 1, r = n - 1;
                while (l < r) {
                    int twoSum = nums[l] + nums[r];
                    if (twoSum == twoSumTarget) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        while(l < r && nums[l] == nums[l-1]) l++;
                    } else if (twoSum > twoSumTarget) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }

		return ans;
    }

}
