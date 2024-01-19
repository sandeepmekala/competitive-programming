package edu.algos.li19_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _PickOrNotPick_G01_SubsetSums {
    public static void main(String args[]) {
        _PickOrNotPick_G01_SubsetSums obj = new _PickOrNotPick_G01_SubsetSums();

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3,1,2));

        ArrayList<Integer> ans = obj.subsetSums(arr, arr.size());
        System.out.println(ans);
    }

    // Problem: https://practice.geeksforgeeks.org/problems/subset-sums2234/1
    // time: O(2^n)
    // space: O(1)
    public ArrayList<Integer> subsetSums(ArrayList<Integer> nums, int n) {
        ArrayList<Integer> sumSubset = new ArrayList<>();
        subsetSums(nums, 0, 0, sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }

    public void subsetSums(ArrayList<Integer> nums, int ind, int sum, ArrayList<Integer> sumSubset) {
        if (ind == nums.size()) {
            sumSubset.add(sum);
            return;
        }
    
        // pick the element
        subsetSums(nums, ind + 1, sum + nums.get(ind), sumSubset);
    
        // Do-not pick the element
        subsetSums(nums, ind + 1, sum, sumSubset);
    }
}
