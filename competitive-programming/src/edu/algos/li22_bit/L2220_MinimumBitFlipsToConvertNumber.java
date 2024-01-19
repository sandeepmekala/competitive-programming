package edu.algos.li22_bit;

public class L2220_MinimumBitFlipsToConvertNumber {

	public static void main(String[] args) {
		L2220_MinimumBitFlipsToConvertNumber obj = new L2220_MinimumBitFlipsToConvertNumber();
		
		System.out.println(obj.minBitFlips(10, 7));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
     * Idea: It is same as num of miss matching bits between to nums. Which is Hamming distance.
     * Shift both start and goal bit by bit and check lsb's. If not matching, count.
	 * */
	public int minBitFlips(int start, int goal) {
        int count = 0;
        for(int i=0; i<32; i++){
            if(((start>>i)&1) != ((goal>>i)&1))
                count++;
        }
        
        return count;
    }

}
