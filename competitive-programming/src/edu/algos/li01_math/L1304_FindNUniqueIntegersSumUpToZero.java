package edu.algos.li01_math;

import java.util.Arrays;

public class L1304_FindNUniqueIntegersSumUpToZero {

	public static void main(String[] args) {
		L1304_FindNUniqueIntegersSumUpToZero obj = new L1304_FindNUniqueIntegersSumUpToZero();
		
		System.out.println(Arrays.toString(obj.sumZero(5)));
	}

	/*
	 * Problem: https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
	 * Idea: Just 1,2,.. -2,-1 from both sides of array
	 * Companies: Microsoft
	 * 
	 * 
	 * */
	public int[] sumZero(int n) {
        int[] result = new int[n];
        for(int i=0; i<n/2; i++){
            result[i] = i+1;
            result[n-1-i] = -(i+1);
        }
        
        return result;
    }
}
