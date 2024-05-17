package  com.algos.li04_twopointers.revised;

public class L26_RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		L26_RemoveDuplicatesFromSortedArray obj = new L26_RemoveDuplicatesFromSortedArray();
		
		int[] nums = new int[] {1,1,1,2};
		System.out.println(obj.removeDuplicates(nums));
	}
	
    // Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    // Idea: Use two pointers. One ptr finds distinct number and other one holds the place to insert the distinct num.
	public int removeDuplicates(int[] nums) {
        int l=0;
        for(int r=1; r<nums.length; r++){
            if(nums[r] != nums[l]){
                nums[++l] = nums[r];                
            }
        } 
        return l+1;
    }

}
