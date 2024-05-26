package  com.algos.core.li03_slidingwindow.revised;

public class L209_MinimumSizeSubarraySum {

	public static void main(String[] args) {
		L209_MinimumSizeSubarraySum obj = new L209_MinimumSizeSubarraySum();
		
		int[] nums = new int[] {2,3,1,2,4,3};
		System.out.println(obj.minSubArrayLen(7, nums));
	}
	
    // Problem: https://leetcode.com/problems/minimum-size-subarray-sum/
    // Idea: Use sliding window as it ask for contiguous sub array.
    // Continuely find sum of nums, if some goes more then target, find the min length of all posibilities.
    // 
	public int minSubArrayLen(int target, int[] nums) {
        int l=0, r=0, sum = 0, minLen = (int)1e9, n = nums.length;
        while(r<n){
            sum += nums[r];
            while(sum >= target){
                minLen = Math.min(minLen, r-l+1);
                sum -= nums[l];
                l++;
            }
            r++;
        }        
        return minLen == (int)1e9? 0: minLen;
    }

}
