package edu.algos.li02_array;

import java.util.ArrayList;
import java.util.List;

public class L448_FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        L448_FindAllNumbersDisappearedInAnArray obj = new L448_FindAllNumbersDisappearedInAnArray();

        int[] nums = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(obj.findDisappearedNumbers(nums));
    }

    /*
     * Problem:
     * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
     * Idea: Just put the number in its index place
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (i + 1 == nums[i] || nums[i] == nums[nums[i] - 1]) { // just skip if the number is already in its correct
                                                                    // position or both the exchanging numbers are same
                i++;
            } else {
                int ind = nums[i] - 1;

                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
            }
        }

        List<Integer> resultList = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (j + 1 != nums[j])
                resultList.add(j + 1);
        }
        return resultList;
    }

}
