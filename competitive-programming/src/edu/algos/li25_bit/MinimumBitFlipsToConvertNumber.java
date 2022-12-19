package edu.algos.li25_bit;

public class MinimumBitFlipsToConvertNumber {

	public static void main(String[] args) {
		MinimumBitFlipsToConvertNumber obj = new MinimumBitFlipsToConvertNumber();
		
		System.out.println(obj.minBitFlips(10, 7));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
	 * */
	public int minBitFlips(int start, int goal) {
        int count = 0;
        while(start != 0 || goal != 0){
            if((start&1) != (goal&1))
                count++;
            start >>= 1;
            goal >>= 1;
        }
        
        return count;
    }

}
