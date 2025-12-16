package com.algos.topics.li19_bit.revised;

public class L260_SingleNumberIII {

    public static void main(String[] args) {
        L260_SingleNumberIII obj = new L260_SingleNumberIII();
        int[] nums = new int[] {1,2,1,3,2,5};
        int[] res = obj.singleNumber(nums);
        System.out.println(res[0] + " " + res[1]);
    }

    // Problem: https://leetcode.com/problems/single-number-iii/
    // Idea: XOR all numbers to get xor of two numbers. Find rightmost set bit in xor to seperate two number based on that bit into 2 buckets.
    // This bit is always different for two nums.
    // Separate all nums to two buckets based on this bit. Duplicate nums will go to same bucket.
    // XOR all nums in bucket to cancel duplicate nums and get single nums;
    // Time: O(n), Space: O(1)
    public int[] singleNumber(int[] nums) {
        // Separate all nums to two
        long xor = 0;
        for(int num: nums)
            xor ^= num;
        int rightMost = (int)((xor & (xor-1))^xor);
        int b1=0, b2=0;
        for(int num: nums){
            if((num & rightMost) > 0 )
                b1 ^= num;
            else
                b2 ^= num;
        }

        return new int[]{b1, b2};
    }
}
