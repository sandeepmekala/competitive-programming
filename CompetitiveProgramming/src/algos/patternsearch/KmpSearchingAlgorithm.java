package algos.patternsearch;

import java.util.Arrays;

public class KmpSearchingAlgorithm {

	public static void main(String[] args) {
		String input = "ABABDABACDABABCABAB";
		String pattern = "ABABCABAB";
		kmpSearch(input, pattern);
	}

	// we construct longest proper prefix which is also suffixes for the patter so that we don't search already search prefixes.
	// this lps contains the indexes to fallback if there is a miss match
	// these indexes are basically the length of the longest proper prefix which is already compared
	// O(n)
	private static void kmpSearch(String input, String pattern) {
		int n = input.length();
		int m = pattern.length();
		int[] lps = new int[m];
		
		constructLps(lps, pattern, m);
		
		int i=0, j=0;
		while(i<n) {
			if(input.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
				if(j == m) {
					System.out.println("Search found at: "+(i-j));
					j=lps[j-1];
				}
			}else {
				if(j>0) {
					j=lps[j-1];
				}else {
					i++;
				}
			}
			
		}
		
		System.out.println(Arrays.toString(lps));
	}

	private static void constructLps(int[] lps, String pattern, int n) {
		lps[0] = 0;
		int len = 0;
		int i=1;
		while(i<n) {
			if(pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}else {
				if(len > 0) {
					len = lps[len-1];
				}else {
					lps[i] = len;
					i++;
				}
			}
		}
	}

}
