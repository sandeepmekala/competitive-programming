package edu.algos.li01_bit;

public class A01_NumToBinary {

	public static void main(String[] args) {
		printBinaryIteratively(4);
		
		printBinaryRecursively(4);
		System.out.println();
		
		printBinaryRecursivelyWithRightShift(4);
		System.out.println();
		
		System.out.println(Integer.toBinaryString(4));
	}
	private static void printBinaryIteratively(int number){
		String str = "";
		for(int i=number; i>0; i = i/2){
			str = (i%2)+""+str;			
		}
		System.out.println(str);
	}
	private static void printBinaryRecursively(int number){
		if(number > 0){
			printBinaryRecursively(number/2);
		}
		System.out.print(number%2);
	}
	private static void printBinaryRecursivelyWithRightShift(int number){
		if(number > 0){
			printBinaryRecursively(number>>1);
		}
		System.out.print(number&1);
	}
}
