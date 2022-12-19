package edu.algos.li09_string;

public class LicenseKeyFormatting {

	public static void main(String[] args) {
		LicenseKeyFormatting obj = new LicenseKeyFormatting();
		
		String s = "5F3Z-2e-9-w";
		System.out.println(obj.licenseKeyFormatting(s, 4));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/license-key-formatting/
	 * 
	 * */
	public String licenseKeyFormatting(String s, int k) {
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for(int i=s.length()-1; i>=0; i--){
            
            char ch = s.charAt(i);
            if(ch == '-') continue;
            
            if(count == k){
                sb.insert(0, '-');
                count = 0;
            }
            sb.insert(0, Character.toUpperCase(ch));
            count++;
        }
        
        return sb.toString();
    }

}
