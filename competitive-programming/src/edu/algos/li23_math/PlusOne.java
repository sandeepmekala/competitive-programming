package edu.algos.li23_math;

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		PlusOne obj = new PlusOne();
		System.out.println(Arrays.toString(obj.plusOne(new int[] {1,2,3})));
	}
	
	public int[] plusOne(int[] digits) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        int carry = 1;
        for(int i=digits.length-1; i>=0; i--){
            int sum = carry+digits[i];
            
            if(sum > 9){
                carry = 1;
            }else{
                carry = 0;
            }
            result.add(0, sum%10);
        }
        if(carry > 0){
            result.add(0, carry);
        }
        int[] result2 = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            result2[i] = result.get(i);
        }
        return result2;
    }
}
