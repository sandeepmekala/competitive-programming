package edu.algos.patternsearch;

import java.util.Arrays;

public class KmpSearchingAlgorithm {

	public static void main(String[] args) {
		String input = "ABABDABACDABABCABAB";
		String pattern = "ABABCABAB";
		kmpSearch(input, pattern);
	}

	// concept: we construct longest proper prefix which is also suffixes for the pattern so that we don't search already searched prefixes.
	// this lps contains the indexes to fallback if there is a miss match
	// these indexes are basically the length of the longest proper prefix which is already compared
	// O(n+m) = O(n)
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

	/*
	 * 	Concept: build lps array to store the next index we should jumb incase missmatch with string
	 * 	start with j=0, i=1
	 * 	if, pat[i] and pat[j] match, store lps[i] = j+1. This means, till j it matched, incase of missmatch it should fallback to j++ index. Increase i,j
	 *	Incase miss match, we already stored the next ind of patter with last matched j. switch j to that.(lps[j-1])
	 *	
	 *	Time complexity: O(m)	 
	 * */
	private static void constructLps(int[] lps, String pattern, int m) {
		lps[0] = 0;
		int j = 0;
		int i=1;
		while(i<m) {
			if(pattern.charAt(i) == pattern.charAt(j)) {
				lps[i] = j+1;
				j++;				
				i++;
			}else {
				if(j > 0) {
					j = lps[j-1];
				}else {
					lps[i] = j;
					i++;
				}
			}
		}
	}

}
