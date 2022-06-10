package edu.algos.divandcon;

public class PowOfX {

	public static void main(String[] args) {
		PowOfX obj = new PowOfX();
		int x = 2;
		int y = 3;
		
		System.out.println(obj.myPow(x,y));
	}

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
        }
        else{
            return x*temp*temp;  // if power is odd
        }
    }

}
