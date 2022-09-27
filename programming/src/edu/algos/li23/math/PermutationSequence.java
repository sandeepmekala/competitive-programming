package edu.algos.li23.math;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public static void main(String[] args) {
		PermutationSequence obj = new PermutationSequence();
		
		int n=3, k=3;
		System.out.println(obj.getPermutation(n, k));
	}
	
	public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        for(int i=1; i<n; i++){
            fact = fact*i;
            nums.add(i);
        }
        nums.add(n);
        
        k = k-1;
        String result = "";
        while(true){
            int reminder = k/fact;
            result += nums.get(reminder);
            nums.remove(reminder);
            if(nums.size() == 0) break;
            
            k = k%fact;
            fact = fact/nums.size();
        }
        
        return result;
    }

}
