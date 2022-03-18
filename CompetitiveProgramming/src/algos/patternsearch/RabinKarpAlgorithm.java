package algos.patternsearch;

public class RabinKarpAlgorithm {

	public static void main(String[] args) {
		String input = "GEEKS FOR GEEKS";
		String pattern = "GEEK";
		
		rabinKarpAlgorithm(input, pattern);
	}

	// O(n*m)
	private static void rabinKarpAlgorithm(String input, String pattern) {
		int n = input.length();
		int m = pattern.length();
		int pHash = hash(pattern);
		int hash = hash(input.substring(0,m));
		
		for(int i=0; i<n-m; i++) {
			String substring = input.substring(i,i+m);
			if(i > 0) {
				hash = rehash(hash, input.charAt(i-1), substring);
			}
			System.out.println(substring+":"+hash);
			
			if(hash == pHash) {
				int j;
				for(j=0; j<pattern.length(); j++) {
					if(input.charAt(i+j) != pattern.charAt(j)) {
						break;
					}
				}
				if(j == m) {
					System.out.println("Found at: "+i);
				}
			}
		}
	}
	private static int hash(String substring) {
		int hash = 0;
		int prime = 3;
		for(int i=0; i<substring.length(); i++) {
			hash += substring.charAt(i)*(Math.pow(prime, i));
		}
		return hash;
	}
	private static int rehash(int oldHash, char prevStartingChar, String substring) {
		int m = substring.length();
		int hash;
		int prime = 3;
		oldHash = oldHash-prevStartingChar;
		oldHash = oldHash/prime;
		hash = oldHash+((substring.charAt(m-1))*(int)Math.pow(prime, m-1));
		return hash;
	}
}
