package  com.algos.li24_string;

public class _Pattern_A03_RabinKarpAlgorithm {

	public static void main(String[] args) {
		_Pattern_A03_RabinKarpAlgorithm obj = new _Pattern_A03_RabinKarpAlgorithm();

		String input = "GEEKS FOR GEEKS";
		String pattern = "GEEK";
		
		obj.rabinKarpAlgorithm(input, pattern);
	}

	// Idea: Find the substring of input of pattern length and find a hash of both. If hash is same compare the substring and pattern.
	// Calculation hash of subsequent substrings is done with rehashing to improve performance.
	// O(n*m)
	public void rabinKarpAlgorithm(String str, String pat) {
		int n = str.length(), m = pat.length();
		int patHash = hash(pat);
		int strHash = hash(str.substring(0,m));
		
		for(int i=0; i<n-m; i++) {
			String substr = str.substring(i,i+m);
			if(i > 0) {
				strHash = rehash(strHash, str.charAt(i-1), substr);
			}
			
			if(strHash == patHash) {
				int j;
				for(j=0; j<pat.length(); j++) {
					if(str.charAt(i+j) != pat.charAt(j)) {
						break;
					}
				}
				if(j == m) {
					System.out.println("Found at: "+i);
				}
			}
		}
	}

	private int hash(String substring) {
		int hash = 0;
		int prime = 3;
		for(int i=0; i<substring.length(); i++) {
			hash += substring.charAt(i)*(Math.pow(prime, i));
		}
		return hash;
	}
	
	private int rehash(int oldHash, char prevStartingChar, String substring) {
		int m = substring.length(), prime = 3;
		int hash;
		oldHash = oldHash-prevStartingChar;
		oldHash = oldHash/prime;
		hash = oldHash+((substring.charAt(m-1))*(int)Math.pow(prime, m-1));
		return hash;
	}
}
