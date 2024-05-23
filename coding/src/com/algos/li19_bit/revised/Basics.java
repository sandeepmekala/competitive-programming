package  com.algos.li19_bit.revised;

public class Basics {

	public static void main(String[] args) {
		Basics obj = new Basics();

		// Binary iteratively
		obj.printBinaryIteratively(4);
		
		// Binary recursively
		obj.printBinaryRecursively(4);
		System.out.println();
		
		// Binary recursively with right shift	
		obj.printBinaryRecursivelyWithRightShift(4);
		System.out.println();
		
		System.out.println(Integer.toBinaryString(4));
	}
	private void printBinaryIteratively(int n){
		StringBuffer sb = new StringBuffer();
		while(n > 0){
			sb.append(n%2);
			n = n/2;
		}
		System.out.println(sb.reverse().toString());
	}
	private void printBinaryRecursively(int n){
		if(n > 0){
			printBinaryRecursively(n/2);
		}
		System.out.print(n%2);
	}
	private void printBinaryRecursivelyWithRightShift(int n){
		if(n > 0){
			printBinaryRecursively(n>>1);
		}
		System.out.print(n&1);
	}
}
