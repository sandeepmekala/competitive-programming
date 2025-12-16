package li20_math;

import java.util.ArrayList;
import java.util.List;

public class PrimaFactors {

        public static void main(String[] args) {
            PrimaFactors obj = new PrimaFactors();
            System.out.println(obj.primeFactors(315));
            System.out.println(obj.primeFactors(16));
        }

        // Time complexity: O(sqrt(n) * log(n))
        public List<Integer> primeFactors(int n){
            List<Integer> factors = new ArrayList<>();
            for(int i=2; i*i<n; i++){
                if(n%i == 0){
                    factors.add(i);
                    while(n%i == 0){
                        n = n/i;
                    }
                }
            }
            if(n > 1) factors.add(n);   // if we run till sqrt(n) then n can be prime number factor

            return factors;
        }
}
