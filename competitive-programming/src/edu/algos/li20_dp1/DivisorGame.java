package edu.algos.li20_dp1;

import java.util.HashMap;

public class DivisorGame {

	public static void main(String[] args) {
		DivisorGame obj = new DivisorGame();
		
		System.out.println(obj.divisorGame(10));
	}

	/*
	 * Problem: https://leetcode.com/problems/divisor-game/
	 * 
	 * */
	public boolean divisorGame(int n) {
        HashMap<Integer, Boolean> mem = new HashMap<>();
        return divide(n, mem);
    }
    
    private boolean divide(int n, HashMap<Integer, Boolean> mem){
        if(n == 1) return false;
        if(mem.containsKey(n)) return mem.get(n);
        
        for(int i=1; i<n; i++){
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
