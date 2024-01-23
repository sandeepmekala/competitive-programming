package edu.algos.li06_binarysearch;

import java.util.Arrays;

public class G03_AggressiveCows {
    public static void main(String args[]) {
        G03_AggressiveCows obj = new G03_AggressiveCows();
        
        int[] nums = {1,2,8,4,9};
        int cows = 3;
        
        System.out.println(obj.placeCows(nums, cows));
    }

    public int placeCows(int[] nums, int cows){
        int n = nums.length;
        Arrays.sort(nums);

        int low = 1, high = nums[n - 1] - nums[0];
        int res = -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (isPossible(nums, n, cows, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }

    private boolean isPossible(int a[], int n, int cows, int minDist) {
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
