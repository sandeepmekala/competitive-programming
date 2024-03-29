package edu.algos.li01_bit;

public class L762_PrimeNumberOfSetBitsInBinaryRepresentation {

	public static void main(String[] args) {
		L762_PrimeNumberOfSetBitsInBinaryRepresentation obj = new L762_PrimeNumberOfSetBitsInBinaryRepresentation();
		
		System.out.println(obj.countPrimeSetBits(4, 9));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
     * Idea: Get bit of each num and check if its prime or not.
	 * */
	public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int i=left; i<=right; i++){
            int bitCount = getBitCount(i);
            if(isPrime(bitCount)) count++;
        }
        
        return count;
    }
    
    private int getBitCount(int num){
        int count = 0;
        while(num>0){
            if((num&1) == 1)
                count++;
            num = num>>1;
        }
        return count;
    }
    
    private boolean isPrime(int num){
        int devisors = 0;
        for(int i=1; i<=num; i++){
            if(num%i == 0){
                devisors++;
            }
        }
        
        return devisors == 2;
    }

}
