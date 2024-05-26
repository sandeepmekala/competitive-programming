package  com.algos.core.li05_binarysearch.revised;

public class L540_SingleElementInASortedArray {

	public static void main(String[] args) {
		L540_SingleElementInASortedArray obj = new L540_SingleElementInASortedArray();
		
		int[] nums = new int[] {1,1,2,3,3,4,4,8,8};
		System.out.println(obj.singleNonDuplicate(nums));
	}
	
    // Problem: https://leetcode.com/problems/single-element-in-a-sorted-array/ 
    // Idea: On left side of target num, 1st and 2nd instances of duplicate numbers are at even and odd positions.
	// Vice versa on the right of the number.
	public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(nums.length == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];    

        int low=1, high = nums.length-2;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid-1] != nums[mid] && nums[mid] != nums[mid+1])
                return nums[mid];

            if(mid % 2 == 0){
                if(nums[mid] == nums[mid+1])   // left
                    low = mid+1;
                else
                    high = mid-1;
            }else{
                if(nums[mid] == nums[mid-1])   // left
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        
        return -1;
    }

}
