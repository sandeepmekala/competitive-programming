package edu.algos.li01_array.medium;

import java.util.Arrays;

public class L238_ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		L238_ProductOfArrayExceptSelf obj = new L238_ProductOfArrayExceptSelf();
		System.out.println(Arrays.toString(obj.productExceptSelf(new int[] {1,2,3,4})));
	}

    // Problem: https://leetcode.com/problems/product-of-array-except-self/
    // Idea: Track prefix and suffix products. Result is prefix prod*suffix prod.
	public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int prefixProd = 1;
        int postfixProd = 1;
        for(int i=0; i<nums.length; i++){
            result[i] = prefixProd;    
            prefixProd *= nums[i];
        }
        
        for(int i=nums.length-1; i>=0; i--){
            result[i] *= postfixProd;
            postfixProd *= nums[i];
        }
        
        return result;
    }
}
