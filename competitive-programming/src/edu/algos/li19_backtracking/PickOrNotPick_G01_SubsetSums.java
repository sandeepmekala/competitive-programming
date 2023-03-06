package edu.algos.li19_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PickOrNotPick_G01_SubsetSums {
    public static void main(String args[]) {
        PickOrNotPick_G01_SubsetSums obj = new PickOrNotPick_G01_SubsetSums();

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3,1,2));

        ArrayList<Integer> ans = obj.subsetSums(arr, arr.size());
        System.out.println(ans);
    }

    // Problem: https://practice.geeksforgeeks.org/problems/subset-sums2234/1
    public ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> sumSubset = new ArrayList<>();
        subsetSums(0, 0, arr, N, sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }

    public void subsetSums(int ind, int sum, ArrayList<Integer> arr, int n, ArrayList<Integer> sumSubset) {
        if (ind == n) {
            sumSubset.add(sum);
            return;
        }
    
        // pick the element
        subsetSums(ind + 1, sum + arr.get(ind), arr, n, sumSubset);
    
        // Do-not pick the element
        subsetSums(ind + 1, sum, arr, n, sumSubset);
    }
}
