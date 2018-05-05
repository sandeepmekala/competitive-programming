
public class LogestCommonSubsequenceRecursion {

	public static void main(String[] args) {

		System.out.println(LCS("BATD", "ABACD", 4, 5));

	}
	
	private static int LCS(String p, String q, int m, int n){
		
		if(m==0 || n==0){
			return 0;
		}else if(p.substring(m-1).equals(q.substring(n-1))){
			return 1 + LCS(p.substring(0, m-1), q.substring(0, n-1), m-1, n-1);
		}else{
			int temp1 = LCS(p.substring(0, m-1), q, m-1, n);
			int temp2 = LCS(p, q.substring(0, n-1), m, n-1);
			return Math.max(temp1, temp2);
		}
	}

}
