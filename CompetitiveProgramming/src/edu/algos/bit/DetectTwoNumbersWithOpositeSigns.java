package edu.algos.bit;

public class DetectTwoNumbersWithOpositeSigns {

	public static void main(String[] args) {
		int num1 = -1;
		int num2 = 100;
		System.out.println(detectTwoNumbersWithOpositeSigns(num1, num2));
	}

	// for negative numbers, the last bit is 1 which is sign bit
	// for positive nums it is 0
	// if we xor these 2 nums. result should be -ve if there are of opposite signs
	private static boolean detectTwoNumbersWithOpositeSigns(int num1, int num2) {
		return (num1^num2)<0;
	}
	
}
