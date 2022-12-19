package edu.algos.li25_bit;

public class SumOfTwoIntegers {

	public static void main(String[] args) {
		SumOfTwoIntegers obj = new SumOfTwoIntegers();
		System.out.println(obj.getSum(1, 2));
	}

	public int getSum(int a, int b) {
        int sum = a ^ b;
        int c = (a & b) << 1;
        while(c != 0){
            int tmp = (sum & c) << 1;
            sum = sum ^ c;
            c = tmp;
        }
        
        return sum;
    }
}
