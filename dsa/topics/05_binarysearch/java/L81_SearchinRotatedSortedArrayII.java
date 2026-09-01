public class L81_SearchinRotatedSortedArrayII {

    public static void main(String[] args) {
        L81_SearchinRotatedSortedArrayII obj = new L81_SearchinRotatedSortedArrayII();
        System.out.println(obj.search(new int[] {2,5,6,0,0,1,2}, 0));
    }

    // Problem: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
    // Idea: Search in rotated array algo fails when
    // nums[low] == nums[mid] == nums[high]
    // As we can't figure out which portion is sorted
    // In this case we shring both low and high
    // Time: O(logn) in average case, O(n/2) in worst case
    public boolean search(int[] nums, int target) {
        int low=0, high=nums.length-1;
        while(low<=high){
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return true;
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low++;
                high--;
                continue;
            }

            if (nums[low] <= nums[mid]) {   // check if left sorted
                if (nums[low] <= target && nums[mid] >= target)
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
        return false;
    }
}
