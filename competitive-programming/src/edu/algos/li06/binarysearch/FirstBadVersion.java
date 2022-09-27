package edu.algos.li06.binarysearch;

public class FirstBadVersion {

	public static void main(String[] args) {
		FirstBadVersion obj = new FirstBadVersion();
		
		System.out.println(obj.firstBadVersion(5));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/first-bad-version/
	 * 
	 * */
	public int firstBadVersion(int n) {
        int l = 0, r=n, res = -1;
        while(l<=r){
            int m = l+(r-l)/2;
            if(isBadVersion(m)){
                res = m;
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return res;
    }

	private boolean isBadVersion(int m) {
		return m>=4;
	}

}
