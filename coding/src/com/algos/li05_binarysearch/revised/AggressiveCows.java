package  com.algos.li05_binarysearch.revised;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String args[]) {
        AggressiveCows obj = new AggressiveCows();
        
        int[] nums = {1,2,8,4,9};
        int cows = 3;
        
        System.out.println(obj.placeCows(nums, cows));
    }

    // Problem: https://www.spoj.com/problems/AGGRCOW/
    // Idea: BS range 1 to max distance between stalls
    public int placeCows(int[] nums, int cows){
        int n = nums.length;
        Arrays.sort(nums);

        int low = 1, high = nums[n - 1] - nums[0];
        int res = -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (canWePlace(nums, n, cows, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }

    private boolean canWePlace(int a[], int n, int cows, int minDist) {
        int cntCows = 1;
        int lastPlacedCow = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] - lastPlacedCow >= minDist) {
                cntCows++;
                lastPlacedCow = a[i];
            }
        }
        return cntCows >= cows;
    }
}
