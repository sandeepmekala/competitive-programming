package edu.algos.li25.bit;

public class Algo05_MakeArrayElementsZero {

	public static void main(String[] args) {
		int[] number = new int[] {3,5,6};
		System.out.println(makeArrayEmelentsZero(number));
	}

	// numbers can be paired and XoR can be applied
	// xor will be canceling all the even number of 1'
	// so we should make sure there are event 1' at each bit position to achieve this
	private static boolean makeArrayEmelentsZero(int[] numbers) {
		boolean result = true;
		for(int i=0; i<32; i++) {
			int numOfOnes = 0;
			for(int j=0; j<numbers.length; j++) {
				if(((numbers[j]>>i)&1)>0) {
					numOfOnes++;
				}
			}
			if(numOfOnes%2 != 0) {
				result = false;
				break;
			}
		}
		return result;
	}

}
