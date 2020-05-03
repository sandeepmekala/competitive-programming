package algorithms;
public class MaximumSumSubArrayKadaneDynamicProgrammingV1 {

	public static void main(String[] args) {
		int result = findMaxSubArray(new int[]{1,-3,2,1,-1});
		System.out.println(result);
	} 
	private static int findMaxSubArray(int nums[]){
		
		if(nums.length == 0){
			return 0;
		}else if(nums.length == 1){
			return nums[0];
		}	
				
		int global_max = nums[0];
		int current_max = nums[0];
		
		for(int i=1; i<nums.length; i++){
			current_max = Math.max(nums[i], current_max+nums[i]);
			if(current_max > global_max){
				global_max = current_max;
			}
		}
		return global_max;
	}
}