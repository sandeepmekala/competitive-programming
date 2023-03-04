package edu.algos.li08_greedy.medium;

import java.util.Arrays;

public class G04_MinimumNumberOfPlatformsRequired {
    public static void main(String[] args) {
        G04_MinimumNumberOfPlatformsRequired obj = new G04_MinimumNumberOfPlatformsRequired();

        int[] arr = { 900, 945, 955, 1100, 1500, 1800 };
        int[] dep = { 920, 1200, 1130, 1150, 1900, 2000 };
        int n = arr.length;
        int totalCount = obj.findPlatform(arr, dep, n);
        System.out.println("Minimum number of Platforms required " + totalCount);
    }

    public int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platNeeded = 1, max = 1;
        int i = 1, j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platNeeded++;
                i++;
            } else if (arr[i] > dep[j]) {
                platNeeded--;
                j++;
            }

            if (platNeeded > max)
                max = platNeeded;
        }

        return max;
    }
}
