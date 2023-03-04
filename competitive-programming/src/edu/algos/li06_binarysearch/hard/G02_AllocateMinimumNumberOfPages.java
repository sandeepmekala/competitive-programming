package edu.algos.li06_binarysearch.hard;

import java.util.ArrayList;
import java.util.Arrays;

public class G02_AllocateMinimumNumberOfPages {
    public static void main(String args[]) {
        G02_AllocateMinimumNumberOfPages obj = new G02_AllocateMinimumNumberOfPages();

        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(12,34,67,90));
        int students = 2;
        System.out.println(obj.books(nums, students));
    }

    // Problem: https://www.interviewbit.com/problems/allocate-books/

    public int books(ArrayList<Integer> nums, int students) {
        if (students > nums.size())
            return -1;

        int low = nums.get(0);
        int high = 0;
        for (int i = 0; i < nums.size(); i++) {
            low = Math.min(low, nums.get(i));
            high = high + nums.get(i);
        }
        int res = -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            // cout << low << " " << high << " " << mid << endl;
            if (isPossible(nums, mid, students)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // return res -> this is also correct
        return res;
    }

    boolean isPossible(ArrayList<Integer> nums, int maxAllocation, int students) {
        int allocateStuds = 1;
        int sumAllocated = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (sumAllocated + nums.get(i) > maxAllocation) {
                allocateStuds++;
                sumAllocated = nums.get(i);
                if (sumAllocated > maxAllocation)
                    return false;
            } else {
                sumAllocated += nums.get(i);
            }
        }
        return allocateStuds <= students;
    }
}
