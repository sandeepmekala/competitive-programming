package edu.algos.li07.divandcon;

public class MajorityElement {

	public static void main(String[] args) {
		MajorityElement obj = new MajorityElement();
		
		int[] nums = new int[] {3,2,3};
		System.out.println(obj.majorityElement(nums));
	}

	public int majorityElement(int[] nums) {
        int[] result = majorityElement(nums, 0, nums.length-1);
        return result[0];
    }
    
    private int[] majorityElement(int[] nums, int start, int end) {
        if(start == end){
            return new int[]{nums[start], 1};
        }
        
        int mid = (start+end)/2;
        int[] left = majorityElement(nums, start, mid);
        int[] right = majorityElement(nums, mid+1, end);
        
        if(left[0] == right[0]){
            return new int[]{left[0], left[1]+right[1]};
        } else {
            int leftCount = 0;
            int rightCount = 0;
            for(int i=start; i<=end; i++){
                if(nums[i] == left[0]) leftCount++;
                if(nums[i] == right[0]) rightCount++;
            }
            if(leftCount > rightCount) return left;
            else return right;
        }
        
    }
}
