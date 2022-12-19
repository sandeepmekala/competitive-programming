package edu.algos.li23_math;

public class CountPrimes {

	public static void main(String[] args) {
		CountPrimes obj = new CountPrimes();
		
		System.out.println(obj.countPrimes(10));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/count-primes/
	 * Companies: Amazon
	 * Idea: Sieve of Eratosthenes Algorithm
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
