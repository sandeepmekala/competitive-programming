package  com.algos.li14_backtracking.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PickOrNotPick_SubsetSums {
    public static void main(String args[]) {
        PickOrNotPick_SubsetSums obj = new PickOrNotPick_SubsetSums();

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3,1,2));

        List<Integer> ans = obj.subsetSums(arr, arr.size());
        System.out.println(ans);
    }

    // Problem: https://practice.geeksforgeeks.org/problems/subset-sums2234/1
    // time: O(2^n)
    // space: O(1)
    public List<Integer> subsetSums(List<Integer> nums, int n) {
        ArrayList<Integer> sumSubset = new ArrayList<>();
        subsetSums(nums, 0, 0, sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }

    public void subsetSums(List<Integer> nums, int ind, int sum, List<Integer> sumSubset) {
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
