package edu.algos.li04_twopointers.twopointers;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
		
		int[] nums = new int[] {1,1,2};
		System.out.println(obj.removeDuplicates(nums));
	}
	
	public int removeDuplicates(int[] nums) {
        int j=0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[j]){
                nums[++j] = nums[i];                
            }
        }
        return j+1;
    }

}
