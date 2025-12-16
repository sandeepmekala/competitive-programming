package com.algos.topics.li05_binarysearch.revised;

public class L162_FindPeakElement {

    public static void main(String[] args) {
        L162_FindPeakElement obj = new L162_FindPeakElement();
        System.out.println(obj.findPeakElement(new int[] {1,2,3,1}));   // 2
    }

    // Problem: https://leetcode.com/problems/find-peak-element/
    // Idea: Any peek element. If mid is greater than mid-1, then peak is in right part, else peak is in left part
    // Time: O(logn)
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(nums.length == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int low=1, high=n-2;
        while(low <= high){
            int mid = (low+high)/2;
            if((nums[mid-1] < nums[mid]) && nums[mid] > nums[mid+1])
                return mid;
            if(nums[mid] > nums[mid-1])
                low = mid+1;
            else
                high = mid-1;
        }

        return -1;
    }
}
