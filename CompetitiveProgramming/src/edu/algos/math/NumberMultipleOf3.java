package edu.algos.math;

public class NumberMultipleOf3 {

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
			int oddCount = 0;
			int evenCount = 0;
			while(n != 0) {
				if((n&1) > 0) {
					oddCount++;
				}
				n = n>>1;
				if((n&1) > 0) {
					evenCount++;
				}
				n = n>>1;
			}
			if((oddCount - evenCount)%3 == 0) {
				return true;
			}
		}
		return false;
	}

}
