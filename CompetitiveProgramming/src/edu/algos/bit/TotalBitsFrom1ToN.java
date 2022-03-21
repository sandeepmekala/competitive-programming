package edu.algos.bit;

public class TotalBitsFrom1ToN {

	public static void main(String[] args) {
		int number = 7;
		System.out.println(countBits(number));
	}

	private static int countBits(int number) {
		if(number <= 1) {
			return number;
		}
		int x = findLowestPowOf2(number);
		int bitsUntilLowestPowOd2 =  x*(int)Math.pow(2, x-1);
		int OneBitsAfterLowestPowOf2 = number-(int)Math.pow(x, 2);
		int numOfBitsInDiffAmount = countBits(number-(int)Math.pow(x, 2));
		
		return bitsUntilLowestPowOd2+OneBitsAfterLowestPowOf2+numOfBitsInDiffAmount;
	}
	private static int findLowestPowOf2(int number) {
		int x=1;
		while(x<number) {
			x = x<<1;
		}
		return (int) Math.sqrt(x/2);	// for 7 it will return 2 which 2*2 = 4 which is <7
	}

}
