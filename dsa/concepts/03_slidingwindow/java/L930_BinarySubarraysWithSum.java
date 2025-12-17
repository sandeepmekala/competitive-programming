public class L930_BinarySubarraysWithSum {

    public static void main(String[] args) {
        L930_BinarySubarraysWithSum obj = new L930_BinarySubarraysWithSum();

        int[] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println(obj.numSubarraysWithSum(nums, goal));
    }

    // Problem: https://leetcode.com/problems/binary-subarrays-with-sum/
    // Idea: numSubarraysWithSum(nums, goal) = numSubarraysWithSumLessThenOrEqual(nums, goal) - numSubarraysWithSumLessThenOrEqual(nums, goal-1)
    // Time: O(n)
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarraysWithSumLessThenOrEqual(nums, goal) -
        numSubarraysWithSumLessThenOrEqual(nums, goal-1);
    }

    public int numSubarraysWithSumLessThenOrEqual(int[] nums, int goal) {
        if(goal < 0) return 0;
        int l=0, r=0, sum=0, cnt=0, n=nums.length;
        while(r<n){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }

            if(sum <= goal)
                cnt += (r-l+1);
            r++;
        }

        return cnt;
    }
}
