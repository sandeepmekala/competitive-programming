package edu.algos.li25.bit;

public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger obj = new ReverseInteger();
		System.out.println(obj.reverse(123));
	}

	public int reverse(int x) {
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        
        int res = 0;
        while(x != 0){
            int digit = x%10;
            x = x/10;
            if(res > MAX/10){
                return 0;
            }
            if(res < MIN/10){
                return 0;
            }
            res = res*10 + digit;
        }
        return res;
    }
}
