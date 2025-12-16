package com.algos.topics.li20_math.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountPrimesInRange {
    public static void main(String[] args) {
        CountPrimesInRange obj = new CountPrimesInRange();
        System.out.println(obj.countPrimesInRange(new int[][]{{10, 30}, {5, 32}}));
    }

    // Time complexity: O(q)
    public List<Integer> countPrimesInRange(int[][] queries) {
        int[] primes = getPrimes((int)1e6);

        int cnt = 0;
        for(int i=0; i<(int)1e6; i++){  // prefix sum sieve
            cnt += primes[i];
            primes[i] = cnt;
        }

        List<Integer> ans = new ArrayList<>();
        for(int[] query: queries){
            int l = query[0], r = query[1];
            ans.add(primes[r] - primes[l-1]);
        }

        return ans;
    }

    // Time complexity: O(n * log(log(n)))
    public int[] getPrimes(int n) {
        int[] prime = new int[n+1];
        Arrays.fill(prime, 1);
        for(int i=2; i*i<=n; i++){
            if(prime[i] == 1){
                for(int j=i*i; j<=n; j=j+i){
                    prime[j] = 0;
                }
            }
        }

        return prime;
    }
}
