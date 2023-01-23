package edu.algos.li21_dp.easy;

import java.util.HashMap;

public class OndDimention_Recursion_L1025_DivisorGame {

	public static void main(String[] args) {
		OndDimention_Recursion_L1025_DivisorGame obj = new OndDimention_Recursion_L1025_DivisorGame();
		
		System.out.println(obj.divisorGame(10));
	}

	/*
	 * Problem: https://leetcode.com/problems/divisor-game/
	 * Idea: Both the player plays optimally. Means, choose smallest x so that there won't be chance for others.
     * If x divides n, recursively call function with n-x and expect it to return false in order to return true.
     * If no x found, return false;
     * 
     * TODO
	 * */
	public boolean divisorGame(int n) {
        HashMap<Integer, Boolean> mem = new HashMap<>();
        return divide(n, mem);
    }
    
    private boolean divide(int n, HashMap<Integer, Boolean> mem){
        if(n == 1) return false;
        if(mem.containsKey(n)) return mem.get(n);
        
        for(int i=1; i<n; i++){ // we can't choose 0 and n itself.
            if(n%i == 0){
                if(divide(n-i, mem) == false) {
                    mem.put(n, true);
                    return true;
                }
            }
        }
        
        mem.put(n, false);
        return false;
    }
	
}
