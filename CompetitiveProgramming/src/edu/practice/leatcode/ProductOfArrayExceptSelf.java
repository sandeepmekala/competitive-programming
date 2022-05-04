package edu.practice.leatcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
		System.out.println(Arrays.toString(obj.productExceptSelf(new int[] {1,2,3,4})));
	}
	public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int prefixProd = 1;
        int postfixProd = 1;
        for(int i=0; i<nums.length; i++){
            if(i == 0){
                result[i] = 1;
            }else{
                result[i] = prefixProd;    
            }
            prefixProd *= nums[i];
        }
        
        for(int i=nums.length-1; i>=0; i--){
            if(i < nums.length-1){
                result[i] *= postfixProd;
            }
            postfixProd *= nums[i];
        }
        
        return result;
    }
}
