package edu.algos.li22_bit;

public class L190_ReverseBits {

	public static void main(String[] args) {
		L190_ReverseBits obj = new L190_ReverseBits();
		int num = 43261596;
		System.out.println("binary: "+Integer.toBinaryString(num));
		System.out.println("reverse: "+Integer.toBinaryString(obj.reverseBits(num)));
	}

    // Problem: https://leetcode.com/problems/reverse-bits/
    // Idea: Loop 32 bits from lsb, keep track of a res variable
    // Right shift res and do or with 1 if num has 1 at position i.
	public int reverseBits(int n) {
        int res = 0;
        for(int i=0; i<32; i++){
            res = res << 1; 
            if(((n>>i)&1) == 1){
                res = res ^ 1;
            }
            
        }
        return res;
    }
}
