package algorithms;
import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSumSubArrayBruteforce {

	public static void main(String[] args) {
		int[] result = findMaxSubArray(new int[]{1,-3,2,1,-1});
		System.out.println(Arrays.toString(result));
	} 
	private static int[] findMaxSubArray(int nums[]){
		
		if(nums.length == 0 || nums.length == 1){
			return nums;
		}
		int max = 0;
		for(int k=0; k<nums.length;k++){
			max += nums[k];
		}
		
		int[] result = null;
		for(int i=0; i<nums.length; i++){
			for(int j=i; j<nums.length; j++){
				int subArr[] = Arrays.copyOfRange(nums, i, j+1);
				int tempMax = 0;
				for(int k=0; k<subArr.length;k++){
					tempMax += subArr[k];
				}
				if(tempMax > max){
					max = tempMax;
					result = subArr;
				}
			}
		}
		
		return result;
	}

}
