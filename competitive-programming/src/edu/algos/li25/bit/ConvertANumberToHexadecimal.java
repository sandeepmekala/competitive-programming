package edu.algos.li25.bit;

public class ConvertANumberToHexadecimal {

	public static void main(String[] args) {
		ConvertANumberToHexadecimal obj = new ConvertANumberToHexadecimal();
		
		System.out.println(obj.toHex(26));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/convert-a-number-to-hexadecimal/
	 * Companies: Facebook
	 * */
	public String toHex(int num) {
        if(num == 0) return "0";
        
        StringBuffer sb = new StringBuffer();
        while(num != 0){
            int rem = num&15;
            num >>>= 4;
            
            if(rem < 10) sb.insert(0, String.valueOf(rem));
            else sb.insert(0, (char)('a'-10+rem));
        }
        
        return sb.toString();
    }

}
