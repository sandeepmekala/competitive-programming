
public class L231_PowerOfTwo {

	public static void main(String[] args) {
		L231_PowerOfTwo obj = new L231_PowerOfTwo();

		System.out.println(obj.isPowerOfTwo(16));
	}

	/*
	 * Problem: https://leetcode.com/problems/power-of-two/
	 * Idea: pow of 2 always has only one 1 in bit wise representation
	 * */
	public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;

        while((n&1) == 0)
			n = n>>1;
        return n == 1;
    }

}
