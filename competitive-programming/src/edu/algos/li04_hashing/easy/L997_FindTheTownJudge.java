package edu.algos.li04_hashing.easy;

public class L997_FindTheTownJudge {

	public static void main(String[] args) {
		L997_FindTheTownJudge obj = new L997_FindTheTownJudge();
		
		int[][] trust = new int[][]{{1,3},{2,3}};
		System.out.println(obj.findJudge(3, trust));
	}

	/*
	 * Problem: https://leetcode.com/problems/find-the-town-judge/
     * Idea: From the trust array maintain the count of each truster and trustee.
     * Then, judge will have n-1 trustee's and 0 truster's.
	 * */
	public int findJudge(int n, int[][] trust) {
        int[] truster = new int[n+1];
        int[] trustee = new int[n+1];
        for(int[] t: trust){
            truster[t[0]]++;
            trustee[t[1]]++;
        }
        for(int i=1; i<=n; i++){
            if(trustee[i] == n-1 && truster[i] == 0) return i;
        }
        
        return -1;
    }
}
