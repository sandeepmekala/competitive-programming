
public class L35_SearchInsertPosition {

        public static void main(String[] args) {
            L35_SearchInsertPosition obj = new L35_SearchInsertPosition();
            int[] nums = {1,3,5,6};
            int target = 5;
            System.out.println(obj.searchInsert(nums, target));
        }

        // Problem: https://leetcode.com/problems/search-insert-position/
        // Idea: Simple BS
        // Time: O(logn)
        public int searchInsert(int[] nums, int target) {
            int n = nums.length;
            int low = 0, high=n-1, res=n;
            while(low<=high){
                int mid = (low+high)/2;
                if(nums[mid] >= target){
                    res = mid;
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }

            return res;
        }
}
