package  com.algos.topics.li05_binarysearch;

public class L374_GuessNumberHigherOrLower {

	public static void main(String[] args) {
		L374_GuessNumberHigherOrLower obj  = new L374_GuessNumberHigherOrLower();

		System.out.println(obj.guessNumber(10));
	}

	/*
	 * Problem: https://leetcode.com/problems/guess-number-higher-or-lower/
	 * Companies: Google
     * Idea: Use simple BS.
	 * */
	public int guessNumber(int n) {
        int l=1, r=n;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(guess(mid) == 0){
                return mid;
            }else if(guess(mid) == -1){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return -1;
    }

	private int guess(int mid) {
		return Integer.compare(6, mid);
	}

}
