package  com.algos.core.li20_math.revised;

import java.util.ArrayList;
import java.util.List;

public class L60_PermutationSequence {

	public static void main(String[] args) {
		L60_PermutationSequence obj = new L60_PermutationSequence();
		
		int n=3, k=3;
		System.out.println(obj.getPermutation(n, k));
	}
	
    // Problem: https://leetcode.com/problems/permutation-sequence/ 
    // Idea: Permutations are in the blocks. Use / and % to find the right block every time. 
    // Each block of permutations starts with a number which need to be appended to result.
	public String getPermutation(int n, int k) {
        k = k-1;    // we will be using 0 based indexing

        int fact = 1;   // find (n-1)!
        List<Integer> nums = new ArrayList<>();
        for(int i=1; i<n; i++){
            fact = fact*i;
            nums.add(i);
        }
        nums.add(n);
        
        String result = "";
        while(true){
            int block = k/fact;
            result += nums.get(block);
            nums.remove(block);
            if(nums.size() == 0) break;
            
            k = k%fact;
            fact = fact/nums.size();
        }
        
        return result;
    }

}
