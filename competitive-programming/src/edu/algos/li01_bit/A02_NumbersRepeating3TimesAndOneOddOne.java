package edu.algos.li01_bit;

public class A02_NumbersRepeating3TimesAndOneOddOne {
	public static void main(String[] args) {
		A02_NumbersRepeating3TimesAndOneOddOne obj = new A02_NumbersRepeating3TimesAndOneOddOne();
		int[] numbers = new int[] { 1, 5, 3, 5, 1, 5, 1 };
		System.out.println(obj.findOddNumber(numbers));
	}

	// Idea: Count the number of 1's and do %3. It will nullify all the repeating nums leaving the odd bit.
	public int findOddNumber(int[] numbers) {
		int oddNumber = 0;
		for (int i = 0; i < 32; i++) {
			int bitCount = 0;

			for (int j = 0; j < numbers.length; j++) {
				if (((numbers[j] >> i) & 1) == 1) 
					bitCount++;
			}
			oddNumber += (bitCount % 3) * Math.pow(2, i);
		}
		return oddNumber;
	}
}
