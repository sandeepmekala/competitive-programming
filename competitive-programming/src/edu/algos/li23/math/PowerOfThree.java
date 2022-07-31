package edu.algos.li23.math;

public class PowerOfThree {

	public static void main(String[] args) {
		PowerOfThree obj = new PowerOfThree();
		
		System.out.println(obj.isPowerOfThree(45));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/power-of-three/
	 * 
	 * */
	public boolean isPowerOfThree(int n) {
        if(n == 0) return false;
        
        while(n%3 == 0){
            n = n/3;
        }
        
        return n == 1;
    }

}
