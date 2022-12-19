package edu.algos.li07_divandcon.medium;

public class L50_PowOfX {

	public static void main(String[] args) {
		L50_PowOfX obj = new L50_PowOfX();
		int x = 2;
		int n = 3;
		
		System.out.println(obj.myPow(x,n));
	}

    // Problem: https://leetcode.com/problems/powx-n/
    // Idea: 2^4 = 2^4/2*2^4/2
    // 2^5 = 2^5/2*2^5/2*2^1
    // 2^0 = 1
    // 2^-3 = 1/2^3
	public double myPow(double x, int n){
        if(n >= 0){
            return pow(x, n);    
        }else{
            return 1/pow(x, n);
        }
        
    }
    
    private double pow(double x, int n){
        if(n == 0){
            return 1;
        }
        double temp = pow(x , n / 2);
        if(n % 2 == 0){
            return temp*temp;  // if power is even
        } else{
            return x*temp*temp;  // if power is odd
        }
    }

}
