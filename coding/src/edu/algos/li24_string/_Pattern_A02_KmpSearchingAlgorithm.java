package edu.algos.li24_string;

import java.util.Arrays;

public class _Pattern_A02_KmpSearchingAlgorithm {

	public static void main(String[] args) {
		_Pattern_A02_KmpSearchingAlgorithm kmps = new _Pattern_A02_KmpSearchingAlgorithm();

		String input = "ABABDABACDABABCABAB";
		String pattern = "ABABCABAB";
		kmps.kmpSearch(input, pattern);
	}

	// Idea: We construct longest proper prefix which is also suffixes for the pattern so that we don't search already searched prefixes.
	// This lps contains the indexes to fallback if there is a miss match.
	// These indexes are basically the length of the longest proper prefix which is already compared.
	// O(n+m) = O(n)
	public void kmpSearch(String str, String pattern) {
		int n = str.length(), m = pattern.length();
		int[] lps = new int[m];
		
		constructLps(lps, pattern, m);
		
		int i=0, j=0;
		while(i<n) {
			if(str.charAt(i) == pattern.charAt(j)) {
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

	/*
	 * 	Idea: Build lps array to store the next index we should jump incase missmatch with input string.
	 * 	Start with j=0, i=1
	 * 	If, pat[i] and pat[j] match, store lps[i] = j+1. This means, till j it matched, in case of missmatch it should fallback to j+1 index. Increase i,j
	 *	In case missmatch, we already stored the next ind of pattern with last matched j. Switch j to that.(lps[j-1])
	 *	
	 *	Time complexity: O(m)
	 *
	 * */
	private void constructLps(int[] lps, String pattern, int m) {
		int j = 0, i=1;
		lps[0] = 0;
		while(i<m) {
			if(pattern.charAt(i) == pattern.charAt(j)) {
				lps[i] = j+1;
				i++;
				j++;				
			}else {
				if(j > 0) {
					j = lps[j-1];
				}else {
					lps[i] = 0;
					i++;
				}
			}
		}
	}

}
