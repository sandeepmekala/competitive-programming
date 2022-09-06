package edu.algos.li23.math;

import java.util.Arrays;

public class FindNUniqueIntegersSumUpToZero {

	public static void main(String[] args) {
		FindNUniqueIntegersSumUpToZero obj = new FindNUniqueIntegersSumUpToZero();
		
		System.out.println(Arrays.toString(obj.sumZero(5)));
	}

	/*
	 * Problem: https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
	 * Companies: Microsoft
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
