package edu.algos.li06.binarysearch;

public class GuessNumberHigherOrLower {

	public static void main(String[] args) {
		GuessNumberHigherOrLower obj  = new GuessNumberHigherOrLower();
		
		System.out.println(obj.guessNumber(10));
	}

	/*
	 * Problem: https://leetcode.com/problems/guess-number-higher-or-lower/
	 * Companies: Google
	 * */
	public int guessNumber(int n) {
        int i=1, j=n;
        while(i<=j){
            int mid = i+(j-i)/2;
            if(guess(mid) == 0){
                return mid;
            }else if(guess(mid) == -1){
                j = mid-1;
            }else{
                i = mid+1;
            }
        }
        
        return -1;
    }

	private int guess(int mid) {
		return Integer.compare(6, mid);
	}
	
}
