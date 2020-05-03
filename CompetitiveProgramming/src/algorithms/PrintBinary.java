package algorithms;

public class PrintBinary {

	public static void main(String[] args) {
		printBinaryIteratively(4);
		//printBinaryRecursively(4);
	}
	private static void printBinaryIteratively(int number){
		String str = "";
		for(int i=number; i>0; i = i/2){
			str = (i%2)+""+str;			
		}
		System.err.print(str);
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
