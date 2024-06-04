package  com.algos.core.li05_binarysearch.revised;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String args[]) {
        AggressiveCows obj = new AggressiveCows();
        
        int[] nums = {1,2,8,4,9};
        int c = 3;
        
        System.out.println(obj.placeCows(nums, c));
    }

    // Problem: https://www.spoj.com/problems/AGGRCOW/
    // Place c cows in n stalls such that the minimum distance between any two cows is as large as possible
    // Idea: BS range 1 to max distance between stalls
    public int placeCows(int[] nums, int c){
        int n = nums.length;
        Arrays.sort(nums);

        int low = 1, high = nums[n - 1] - nums[0];
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (canWePlace(nums, n, c, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canWePlace(int[] nums, int n, int c, int dist) {
        int cnt = 1;
        int lastCow = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] - lastCow >= dist) {
                cnt++;
                lastCow = nums[i];
            }
        }
        return cnt >= c;
    }
}
