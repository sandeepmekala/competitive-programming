package com.algos.company.google;

import java.util.ArrayList;
import java.util.List;

public class DP_CoinChangeReconstruction {

    // Problem: https://leetcode.com/discuss/interview-question/4422524/Google-Onsite-interview/2174916
    public static List<Integer> constructOriginalArray(List<Integer> dp) {
        int n = dp.size();
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (dp.get(i) == 1) {
                for (int j = n - 1; j >= i; j--) {
                    dp.set(j, dp.get(j) - dp.get(j - i));
                }
                nums.add(i);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        // Example dp array representing the number of ways to make sums up to the target
        List<Integer> dp = new ArrayList<>();
        int[] dpArray = {1, 0, 1, 0, 1, 1, 2, 1, 2, 1, 3};
        for (int num : dpArray) {
            dp.add(num);
        }

        List<Integer> originalArr = constructOriginalArray(dp);

        // Print the identified coin denominations
        for (int num : originalArr) {
            System.out.print(num + " ");
        }
    }
}
