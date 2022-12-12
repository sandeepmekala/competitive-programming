package edu.algos.li04_twopointers.twopointers;

public class ReverseVowelsOfAString {

	public static void main(String[] args) {
		ReverseVowelsOfAString obj = new ReverseVowelsOfAString();
		
		System.out.println(obj.reverseVowels("hello"));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/reverse-vowels-of-a-string/
	 * Companies: Google, Amazon
	 * */
	public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int i=0, j=n-1;
        while(i<j){
            while(i<n && !isVowel(chars[i])) i++;
            while(j>=0 && !isVowel(chars[j])) j--;
            
            if(i<j){
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
        
        return String.valueOf(chars);
    }
    
    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

}
