package edu.algos.li09_string.easy;

public class L520_DetectCapital {

	public static void main(String[] args) {
		L520_DetectCapital obj = new L520_DetectCapital();
		
		String word = "USA";
		System.out.println(obj.detectCapitalUse(word));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/detect-capital/
	 * Idea: Use startCapital and continuesCapital vars to track the status
     * CHECK
	 * */
	public boolean detectCapitalUse(String word) {
		boolean startCapital = false, continuesCapital = false;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(i == 0)
                if(ch>='A' && ch<='Z') { startCapital = true; continue; }
            if(i == 1)
                if(ch>='A' && ch<='Z') continuesCapital = true; 
            
            if(startCapital && continuesCapital && ch>='a' && ch<='z') return false;
            if(startCapital && !continuesCapital && ch>='A' && ch<='Z') return false;
            if(!startCapital && ch>='A' && ch<='Z') return false;
        }
        
        return true;
    }

}
