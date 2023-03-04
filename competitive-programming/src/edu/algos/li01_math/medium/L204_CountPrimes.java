package edu.algos.li01_math.medium;

public class L204_CountPrimes {

	public static void main(String[] args) {
		L204_CountPrimes obj = new L204_CountPrimes();
		
		System.out.println(obj.countPrimes(10));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/count-primes/
	 * Companies: Amazon
	 * Idea: For each i from 2 to n and mark all the multiples of i as not primes in an array. Repeat the same for every not marked i.
     * Sieve of Eratosthenes Algorithm
	 * */
	public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n+1];
        int count = 0;
        for(int i=2; i<n; i++){
            if(notPrime[i] == false){
                count++;
                for(int j=2; i*j<n; j++){
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }

}
