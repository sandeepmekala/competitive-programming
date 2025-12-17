import java.util.HashMap;
import java.util.Map;

public class L992_SubarrayswithKDifferentIntegers {

    public static void main(String[] args) {
        L992_SubarrayswithKDifferentIntegers obj = new L992_SubarrayswithKDifferentIntegers();

        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(obj.subarraysWithKDistinct(nums, k));
    }

    // Problem: https://leetcode.com/problems/subarrays-with-k-different-integers/
    // Idea: subarraysWithKDistinct(nums, k) = subarraysWithLessThenOrEqualToKDistinct(nums, k) - subarraysWithLessThenOrEqualToKDistinct(nums, k-1)
    // Time: O(n)
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithLessThenOrEqualToKDistinct(nums, k) -
        subarraysWithLessThenOrEqualToKDistinct(nums, k-1);
    }

    public int subarraysWithLessThenOrEqualToKDistinct(int[] nums, int k) {
        int l=0, r=0, cnt=0, n=nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        while(r<n){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            while(map.size() > k){
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                l++;
            }

            if(map.size() <= k)
                cnt += (r-l+1);
            r++;
        }
        return cnt;
    }
}
