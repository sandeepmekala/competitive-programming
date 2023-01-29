package edu.algos.li01_math.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class L66_PlusOne {

	public static void main(String[] args) {
		L66_PlusOne obj = new L66_PlusOne();
		System.out.println(Arrays.toString(obj.plusOne(new int[] {1,2,3})));
	}

	// Problem: https://leetcode.com/problems/plus-one/
    // Idea: In 999 case carry could propagate from right to left. Hence, process right to left.
    // 
	public int[] plusOne(int[] digits) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int carry = 1, n=digits.length;
        for(int i=n-1; i>=0; i--){
            int sum = carry+digits[i];
            temp.add(0, sum%10);
            carry = sum/10;
        }
        if(carry > 0)
            temp.add(0, carry);

        ;
        // TODO
        int[] result = new int[temp.size()]; 
        for(int i=0; i<temp.size(); i++){
            result[i] = temp.get(i);
        }
        return result;
    }
}
