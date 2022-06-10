package edu.algos.bit;

public class Algo03_NumbersRepeating3TimesAndOneOddOne {

	public static void main(String[] args) {
		Algo03_NumbersRepeating3TimesAndOneOddOne obj = new Algo03_NumbersRepeating3TimesAndOneOddOne();
		int[] numbers = new int[] {1,5,3,5,1,5,1};
		System.out.println(obj.findOddNumber(numbers));
	}
	
	// count the number of 1's and do %3. it will nullify all the repeating numbers leaving the odd bit.
	private int findOddNumber(int[] numbers) {
		int oddNumber = 0; 
		for(int i=0; i<32; i++) {
			int noOfOnes = 0;	
			
			for(int j=0; j<numbers.length; j++) {
				if(((numbers[j]>>i)&(1))>0) {
					noOfOnes++;
				}
			}
			oddNumber += (noOfOnes%3)*(Math.pow(2, i));
		}
		return oddNumber;
	}

}
