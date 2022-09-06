package edu.algos.li03.hashing;

import java.util.HashMap;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

	public static void main(String[] args) {
		PairsOfSongsWithTotalDurationsDivisibleBy60 obj = new PairsOfSongsWithTotalDurationsDivisibleBy60();
		
		int[] time = new int[] {30,20,150,100,40};
		System.out.println(obj.numPairsDivisibleBy60(time));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
	 * 
	 * */
	public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int num: time){
            int rem = num%60;
            if(rem == 0 || rem == 30){
                if(map.containsKey(rem))
                    count += map.get(rem);
            }else{
                if(map.containsKey(60-rem))
                    count += map.get(60-rem);
            }
            
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        
        return count;
    }

}
