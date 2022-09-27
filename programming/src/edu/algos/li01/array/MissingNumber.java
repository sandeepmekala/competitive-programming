package edu.algos.li01.array;

public class MissingNumber {

	public static void main(String[] args) {
		MissingNumber obj = new MissingNumber();
		System.out.println(obj.missingNumber(new int[] {3,0,1}));
	}

	 public int missingNumber(int[] nums) {
	        int n = nums.length;
	        int sum = 0;
	        for(int i=0; i<n; i++){
	            sum += nums[i];
	        }
	        int expectedSum = (n*(n+1))/2;
	        return expectedSum - sum;
	    }
}
