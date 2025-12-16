package li20_math;

import java.util.ArrayList;
import java.util.List;

public class smallestPrimeFactor {
    public static void main(String[] args) {
        smallestPrimeFactor obj = new smallestPrimeFactor();
        System.out.println(obj.smallestPrimeFactor(new int[]{315, 16}));
    }

    // Time complexity: O(q * log(n))
    public List<List<Integer>> smallestPrimeFactor(int[] queries){
        int[] primes = getSmallestPrimeFactors((int)1e6);

        List<List<Integer>> ans = new ArrayList<>();
        for(int n: queries){
            ans.add(new ArrayList<>());
            while(n > 1){
                ans.get(ans.size()-1).add(primes[n]);
                n = n/primes[n];
            }
        }

        return ans;
    }

    // Time complexity: O(n * log(log(n)))
    public int[] getSmallestPrimeFactors(int n) {
        int[] prime = new int[n+1];
        for(int i=0; i<=n; i++)
            prime[i] = i;

        for(int i=2; i*i<=n; i++){
            if(prime[i] == i){
                for(int j=i*i; j<=n; j=j+i){
                    if(prime[j] == j)
                        prime[j] = i;
                }
            }
        }

        return prime;
    }
}
