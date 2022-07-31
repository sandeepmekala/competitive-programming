package edu.algos.li23.math;

import java.util.HashMap;

public class XOfAKindInADeckOfCards {

	public static void main(String[] args) {
		XOfAKindInADeckOfCards obj = new XOfAKindInADeckOfCards();
		
		int[] deck = new int[] {1,2,3,4,4,3,2,1};
		System.out.println(obj.hasGroupsSizeX(deck));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
	 * 
	 * */
	public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<deck.length; i++){
            map.put(deck[i], map.getOrDefault(deck[i], 0)+1);
        }
        
        int res = 0;
        for(int count: map.values()){
            res = gcd(res, count);
        }
        
        return res > 1;
    }
    
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }

}
