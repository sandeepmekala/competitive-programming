package edu.algos.li18.graph;

public class FindTheTownJudge {

	public static void main(String[] args) {
		FindTheTownJudge obj = new FindTheTownJudge();
		
		int[][] trust = new int[][]{{1,3},{2,3}};
		System.out.println(obj.findJudge(3, trust));
	}

	/*
	 * Problem: https://leetcode.com/problems/find-the-town-judge/
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
