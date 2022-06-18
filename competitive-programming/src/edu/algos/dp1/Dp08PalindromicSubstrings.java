package edu.algos.dp1;

public class Dp08PalindromicSubstrings {

	public static void main(String[] args) {
		Dp08PalindromicSubstrings obj = new Dp08PalindromicSubstrings();

		String text = "aaa";
		System.out.println(obj.countSubstrings(text));
	}

	public int countSubstrings(String s) {
        int n = s.length();
		boolean[][] mem = new boolean[n][n];
		
		int count = 0;
		for(int l=0; l<n; l++) {
			for(int i=0; i<n-l; i++) {
				int j = i+l;
				if (i == j) {
					mem[i][j] = true;						//handles "b"
				} else if (s.charAt(i) == s.charAt(j)) {
					if(l == 1) {							//handles "bb"
						mem[i][j] = true;
					}else {
						mem[i][j] = mem[i + 1][j - 1];
					}
				}
				
				if(mem[i][j]) {
					count += 1;
				}
			}
		}
		return count;
    }

}
