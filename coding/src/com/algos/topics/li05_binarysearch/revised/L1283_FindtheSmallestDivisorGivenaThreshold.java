package com.algos.topics.li05_binarysearch.revised;

public class L1283_FindtheSmallestDivisorGivenaThreshold {
    public static void main(String[] args) {
        L1283_FindtheSmallestDivisorGivenaThreshold obj = new L1283_FindtheSmallestDivisorGivenaThreshold();
        int[] nums = {1,2,5,9};
        int threshold = 6;
        System.out.println(obj.smallestDivisor(nums, threshold));
    }

    // Problem: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
    // Idea: Simple BS on range 1 to max element in nums
    // Time: O(nlog(max))
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int num: nums)
            max = Math.max(max, num);

        int low = 1, high = max, ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(sumDivisors(nums, mid) <= threshold){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    private int sumDivisors(int[] nums, int mid) {
        int sum = 0;
        for(int num: nums){
            sum += Math.ceil((num*1.0)/mid);
        }
        return sum;
    }
}
