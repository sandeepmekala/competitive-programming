package com.algos.li05_binarysearch.revised;

public class L34_FindFirstandLastPositionofElementinSortedArray {
        
    public static void main(String[] args) {
        L34_FindFirstandLastPositionofElementinSortedArray obj = new L34_FindFirstandLastPositionofElementinSortedArray();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = obj.searchRange(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }

    // Problem: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    // Idea: Use lower bound and upper bound concepts
    // Time: O(logn)
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int lb = lowerBound(nums, target);
        if(lb == n || nums[lb] != target)
            return new int[]{-1, -1};
        
        int ub = upperBound(nums, target);
        return new int[]{lb, ub-1};
    }

    private int lowerBound(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high=n-1, res=n;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] >= target){
                res = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return res;
    }

    private int upperBound(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high=n-1, res=n;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] > target){
                res = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return res;
    }
}
