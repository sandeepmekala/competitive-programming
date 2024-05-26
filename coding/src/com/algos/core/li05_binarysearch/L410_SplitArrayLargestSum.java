package  com.algos.core.li05_binarysearch;

public class L410_SplitArrayLargestSum {

	public static void main(String[] args) {
		L410_SplitArrayLargestSum obj = new L410_SplitArrayLargestSum();
		
		int[] nums = new int[] {7,2,5,10,8};
		System.out.println(obj.splitArray(nums, 2));
	}

	/*
	 * Problem: https://leetcode.com/problems/split-array-largest-sum/
	 * Companies: Amazon
     * Idea: Apply BS on sum range to find then optimum sum. 
     * Minimum possible sum is max and maximum possible array sum is sum.
     *  
	 * */
	public int splitArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE, sum = 0;
        for(int num: nums){
            max = Math.max(max, num);
            sum += num;
        }
        
        int left = max, right = sum, res = sum;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(valid(nums, mid, k)){
                res = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        
        return res;
    }
    
    private boolean valid(int[] nums, int mid, int k){
        int sum = 0;
        for(int num: nums){
            if(sum+num <= mid){
                sum += num;
            }else{
                k--;
                sum = num;
            }
        }
        
        return k>0;
    }
}
