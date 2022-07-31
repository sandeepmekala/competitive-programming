package edu.algos.li25.bit;

public class AddBinary {

	public static void main(String[] args) {
		AddBinary obj = new AddBinary();
		
		String a = "1010";
		String b = "1011";
		System.out.println(obj.addBinary(a, b));
	}

	/*
	 * Problem: https://leetcode.com/problems/add-binary/
	 * 
	 * */
	public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int carry = 0, i=a.length()-1, j=b.length()-1;
        while(i>=0 || j>=0 || carry != 0){
            int num1 = i>=0? a.charAt(i--) - '0' : 0;
            int num2 = j>=0? b.charAt(j--) - '0' : 0;
            int sum = num1+num2+carry;
            
            if((sum&1) > 0) sb.insert(0, '1');
            else sb.insert(0, '0');
            
            carry = sum>>1;
        }
        
        return sb.toString();
    }
}
