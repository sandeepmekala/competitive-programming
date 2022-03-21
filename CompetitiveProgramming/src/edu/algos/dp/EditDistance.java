package edu.algos.dp;

public class EditDistance {

	public static void main(String[] args) {
		  String str1 = "voldemort";
		  String str2 = "dumbledore";
		  
		  int m = str1.length();
		  int n = str2.length();
		  
		  System.out.println(editDistanceRec(str1, str2, m, n));
		  int[][] mem = new int[m][n];
		  System.out.println(editDistanceTopDown(str1, str2, m, n, mem));
		  
		  mem = new int[m+1][n+1]; // one extra index is needed for empty string
		  System.out.println(editDistanceBottomUp(str1, str2, m, n, mem));
		  
	}
	private static int editDistanceBottomUp(String str1, String str2, int m, int n, int[][] mem) {
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i == 0) {		//means str1 is empty. In this case, we need to insert all the chars of str2
					mem[i][j] = j;
				}else if(j == 0) {
					mem[i][j] =  i;
				}else if(str1.charAt(i-1) == str2.charAt(j-1)) {
					mem[i][j] = mem[i-1][j-1];
				}else {
					mem[i][j] = 1+Math.min(Math.min(mem[i-1][j], mem[i][j-1]), mem[i-1][j-1]);
				}
			}
		}
		return mem[m][n];
	}
	private static int editDistanceTopDown(String str1, String str2, int m, int n, int[][] mem) {
			if(m == 0) {
				return n;
			}else if(n == 0) {
				return m;
			}
			
			if(mem[m-1][n-1] != 0) {
				return mem[m-1][n-1];
			}else {
				if(str1.charAt(m-1) == str2.charAt(n-1)) {
					mem[m-1][n-1] = editDistanceTopDown(str1.substring(0, m-1), str2.substring(0, n-1), m-1, n-1, mem);
				}else {
					mem[m-1][n-1] = 1+Math.min(Math.min((editDistanceTopDown(str1.substring(0, m-1), str2, m-1, n, mem)),
							editDistanceTopDown(str1, str2.substring(0, n-1), m, n-1, mem)),
							editDistanceTopDown(str1.substring(0, m-1), str2.substring(0, n-1), m-1, n-1, mem));
				}
			}
			
			return mem[m-1][n-1];
		
	}
	
	private static int editDistanceRec(String str1, String str2, int m, int n) {
		
		if(m == 0) {
			return n;
		}
		if(n == 0) {
			return m;
		}
		
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			return editDistanceRec(str1.substring(0, m-1), str2.substring(0, n-1), m-1, n-1);
		}else {
			return 1+Math.min(Math.min((editDistanceRec(str1.substring(0, m-1), str2, m-1, n)),
					editDistanceRec(str1, str2.substring(0, n-1), m, n-1)),
					editDistanceRec(str1.substring(0, m-1), str2.substring(0, n-1), m-1, n-1));
		}
	}
}