package edu.algos.bit;

public class Algo06_NumberMultipleOf3 {

	public static void main(String[] args) {
		int n = 7;
		System.out.println(isMultipleOf3(n));
	}

	private static boolean isMultipleOf3(int n) {
		if(n < 0) n = -1*n;
		
		if(n == 0) {
			return true;
		}else if(n == 1 || n == 2) {
			return false;
		}else {
			int oddBitsCount = 0;
			int evenBitsCount = 0;
			while(n != 0) {
				if((n&1) > 0) {
					oddBitsCount++;
				}
				n = n>>1;
				if((n&1) > 0) {
					evenBitsCount++;
				}
				n = n>>1;
			}
			
			if((oddBitsCount - evenBitsCount)%3 == 0) {
				return true;
			}
		}
		return false;
	}

}
