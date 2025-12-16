package  com.algos.topics.li02_hashing;

import java.util.HashMap;

public class L1010_PairsOfSongsWithTotalDurationsDivisibleBy60 {

	public static void main(String[] args) {
		L1010_PairsOfSongsWithTotalDurationsDivisibleBy60 obj = new L1010_PairsOfSongsWithTotalDurationsDivisibleBy60();

		int[] time = new int[] {30,20,150,100,40};
		System.out.println(obj.numPairsDivisibleBy60(time));
	}

	/*
	 * Problem: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
	 * Idea: Similar like Two sum
	 * */
	public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int num: time){
            num = num%60;
            int rem = 60-num;
            if(num == 0 && map.containsKey(num)){
                count += map.get(num);
            } else {
                if(map.containsKey(rem)){
                    count += map.get(rem);
                }
            }

            map.put(num, map.getOrDefault(num, 0)+1);
        }

        return count;
    }

}
