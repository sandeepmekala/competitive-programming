package edu.algos.dp;
public class Algo070_MaximumSumSubArrayKadanesAlgo {

	public static void main(String[] args) {
		Algo070_MaximumSumSubArrayKadanesAlgo obj = new Algo070_MaximumSumSubArrayKadanesAlgo();
		int result = obj.findMaxSubArray(new int[]{1,-3,2,1,-1});
		System.out.println(result);
	} 
	
	//It is DP algo because at each element we have 2 choices. whether to take that element or continue with previous sum OR start a new range
	// concept: continuously add numbers, if sum goes above global sum, update global sum
	// if sum goes negative, reset it to 0.
	private int findMaxSubArray(int nums[]){
		
		if(nums.length == 0){
			return 0;
		}else if(nums.length == 1){
			return nums[0];
		}	

		int start = -1, end = -1, tempStart = 0;
		int global_sum = Integer.MIN_VALUE;
		int local_sum = 0;
		
		for(int i=0; i<nums.length; i++){
			local_sum += nums[i];
			if(local_sum > global_sum){
				global_sum = local_sum;
				start = tempStart;
				end = i;
			}
			if(local_sum < 0) {
				local_sum = 0;
				tempStart = i+1;
			}
		}
		System.out.println(start+":"+end);
		return global_sum;
	}
}