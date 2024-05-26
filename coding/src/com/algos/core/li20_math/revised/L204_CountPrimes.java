package  com.algos.core.li20_math.revised;

import java.util.Arrays;

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
        int[] prime = new int[n+1];
        Arrays.fill(prime, 1);
        for(int i=2; i*i<=n; i++){
            if(prime[i] == 1){
                for(int j=i*i; j<=n; j=j+i){
                    prime[j] = 0;
                }
            }
        }
        
        int count = 0;
        for(int i=2; i<n; i++){
            if(prime[i] == 1)
                count++;
        }
        return count;
    }

}
