package  com.algos.core.li15_dp.revised;

public class OndD_Fib_A01_BinaryStringsWithoutConsecutive1s {

	public static void main(String[] args) {
		OndD_Fib_A01_BinaryStringsWithoutConsecutive1s obj = new OndD_Fib_A01_BinaryStringsWithoutConsecutive1s();
		
		int n = 4;
		System.out.println(obj.count(n));
	}

	/*
	 * n=1	n=3			n=4
	 * 0	0 0 0		0000	1000
	 * 1	0 0 1		0001	1001
	 * 		0 1 0		0010	1010
	 * n=2	0 1 1		0011	1011
	 * 0 0	1 0 0		0100	1100
	 * 0 1	1 0 1		0101	1101
	 * 1 0	1 1 0		0110	1110
	 * 1 1	1 1 1		0111	1111
	 * 
	 * When n=4, first part is same as n=3 as first position is always 0. 
	 * Similarly, in second half last 4 numbers are not valid due consecutive 1's. 
	 * Hence, only 4 numbers are which is equal to n=2.
	 * 
	 * i	0	1	2	3	4
	 * 		1	2	3	5	8
	 * */
	// Time: O(n)
	// Space: O(n)
	private int count(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 2;
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n];
	}

}
