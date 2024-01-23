package  com.algos.li04_twopointers;

public class L26_RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		L26_RemoveDuplicatesFromSortedArray obj = new L26_RemoveDuplicatesFromSortedArray();
		
		int[] nums = new int[] {1,1,1,2};
		System.out.println(obj.removeDuplicates(nums));
	}
	
    // Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    // Idea: Use two pointers. Once finds distinct number and other hold the place to insert the distinct num.
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
