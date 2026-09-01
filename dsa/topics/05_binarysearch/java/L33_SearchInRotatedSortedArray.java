public class L33_SearchInRotatedSortedArray {

	public static void main(String[] args) {
		L33_SearchInRotatedSortedArray obj = new L33_SearchInRotatedSortedArray();
		System.out.println(obj.search(new int[] {4,5,6,7,8,1,2,3}, 8));     // 4
	}

    // Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/
    // Idea: Find sorted portion of array and check if target present in that range as you can check its availability only in sorted portion of array.
    // If yes, do bs on left portion, else do bs on right portion
	public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[low] <= nums[mid]) {   // check if left sorted
                if (nums[low] <= target && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {                        // right sorted
                if (nums[mid] <= target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

}
