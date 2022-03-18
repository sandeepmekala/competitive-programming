package algos.dp;

public class MatchRegExpr {

	public static void main(String[] args) {
		String text = " xaabyc";
		String pattern = " xa*b.c";
		int n = text.length();
		int m = pattern.length();
		System.out.println(match(text, pattern, n, m));
	}
	/*			""	x	a 	*	b	.	c
	 * 		i\j	0	1	2	3	4	5	6		
	 * ""	0	T	F	F	F	F	F	F
	 * x	1	F	T	F	T	F	F	F
	 * a	2	F	F	T	T	F	F	F	
	 * a	3	F	F	F	T	F	F	F
	 * b	4	F	F	F	F	T	F	F
	 * y	5	F	F	F	F	F	T	F
	 * c	6	F	F	F	F	F	F	T
	 * 		
	 * */
	private static boolean match(String text, String pattern, int n, int m) {
		boolean[][] mem = new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(i == 0 && j == 0) {
					mem[i][j] = true;
				}else if(i == 0 || j == 0) {
					mem[i][j] = false;
				}else if(text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.') {
					mem[i][j] = mem[i-1][j-1];
				}else if(pattern.charAt(j) == '*' && mem[i][j-2]) {
					mem[i][j] = true;
				}else if((text.charAt(i) == pattern.charAt(j-1) || pattern.charAt(j-1) == '.') && mem[i-1][j]) {
					mem[i][j] = true;
				}else {
					mem[i][j] = false;
				}
			}
		}
		return mem[n-1][m-1];
	}

}
