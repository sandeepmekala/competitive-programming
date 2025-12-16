
public class L69_SqrtOfX {

	public static void main(String[] args) {
		L69_SqrtOfX obj = new L69_SqrtOfX();
		int input = 8;
		System.out.println(obj.mySqrt(input));
	}

	// Problem: https://leetcode.com/problems/sqrtx/
	// Idea: Simple BS on range 1 to x
	// Time: O(logn)
	public int mySqrt(int x) {
		if(x == 0) return 0;

		int sqrt = -1;
		int low = 1, high = x;
		while(low <= high) {
			int mid = low + (high - low)/2;
			if(mid <= x/mid) {
				sqrt = mid;
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		return sqrt;
	}

}
