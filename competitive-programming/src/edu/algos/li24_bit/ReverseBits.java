package edu.algos.li24_bit;

public class ReverseBits {

	public static void main(String[] args) {
		ReverseBits obj = new ReverseBits();
		int num = 43261596;
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toBinaryString(obj.reverseBits(num)));
	}

	public int reverseBits(int n) {
        int res = 0;
        for(int i=0; i<32; i++){
            res = res << 1; 
            if(((n>>i)&1) > 0){
                res = res ^ 1;
            }
            
        }
        return res;
    }
}
