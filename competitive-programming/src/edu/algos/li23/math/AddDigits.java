package edu.algos.li23.math;

public class AddDigits {

	public static void main(String[] args) {
		AddDigits obj = new AddDigits();
		
		System.out.println(obj.addDigits(123));
	}

	/*
	 * Problem: https://leetcode.com/problems/add-digits/
	 * Companies: Microsoft
	 * 
	 * 	Input: 10
	 	Step 1: 1+0 = 1 (Expected output)
		
		Example 4:
		Input: 11
		Step 1: 1+1 = 2 (Expected output)
		
		Example 5:
		Input: 12
		Step 1: 1+2 = 3 (Expected output)
	 * */
	public int addDigits(int num) {
        if(num == 0) return 0;
        
        if(num%9 == 0){
            return 9;
        }else{
            return num%9;
        } 
            
    }
	
	public int addDigits2(int num) {
        while(true){
            if(num < 10) return num;
            int sum = 0;
            while(num > 0){
                int reminder = num%10;
                num = num/10;
                sum += reminder;
            }
            num = sum;
        }
    }
}
