package edu.algos.patternsearch;

public class NumberOfOccurences {

	public static void main(String[] args) {
		String inputStr = "AABAACAADAABAABA";
		String pattern = "AABA";
		findPattern(inputStr, pattern);
	}

	private static void findPattern(String inputStr, String pattern) {
		for(int i=0; i<=inputStr.length()-pattern.length(); i++) {
			int j;
			for(j=0; j<pattern.length(); j++) {
				if(inputStr.charAt(i+j) != pattern.charAt(j)) {
					break;
				}
			}
			if(j==pattern.length()) {
				System.out.println("Patter found at: "+i);
			}
		}
	}

}
