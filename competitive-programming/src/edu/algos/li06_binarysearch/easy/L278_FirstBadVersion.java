package edu.algos.li06_binarysearch.easy;

public class L278_FirstBadVersion {

	public static void main(String[] args) {
		L278_FirstBadVersion obj = new L278_FirstBadVersion();
		
		System.out.println(obj.firstBadVersion(5));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/first-bad-version/
	 * Idea: Continuouly push BS to right if you find a bad version and update the res.
	 * */
	public int firstBadVersion(int n) {
        int left = 0, right=n, res = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(isBadVersion(mid)){
                res = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return res;
    }

	private boolean isBadVersion(int m) {
		return m>=4;
	}

}
