package edu.algos.search.pattern;

public class Algo01_NumberOfOccurences {

	public static void main(String[] args) {
		String input = "AABAACAADAABAABA";
		String pattern = "AABA";
		findPattern(input, pattern);
	}

	private static void findPattern(String input, String pattern) {
		for(int i=0; i<=input.length()-pattern.length(); i++) {
			int j;
			for(j=0; j<pattern.length(); j++) {
				if(input.charAt(i+j) != pattern.charAt(j)) {
					break;
				}
			}
			if(j==pattern.length()) {
				System.out.println("Patter found at: "+i);
			}
		}
	}

}
