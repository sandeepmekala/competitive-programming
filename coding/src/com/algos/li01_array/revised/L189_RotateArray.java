package com.algos.li01_array.revised;

import java.util.Arrays;

public class L189_RotateArray {
    public static void main(String[] args) {
        L189_RotateArray obj = new L189_RotateArray();

        int nums[] = {1,2,3,4,5,6,7};
        int k = 3;
        obj.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int l=0, r=n-1;
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        }

        l=0; r=k-1;
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        }

        l=k; r=n-1;
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        } 
    }
}
