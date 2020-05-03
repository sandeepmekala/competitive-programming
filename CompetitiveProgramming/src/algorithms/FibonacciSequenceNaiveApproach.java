package algorithms;

public class FibonacciSequenceNaiveApproach {

	public static void main(String[] args) {
		
		System.out.println(fib(4));

	}
	
	private static int fib(int n){
		if(n==1 || n==2){
			return 1;
		}else{
			return fib(n-1)+fib(n-2);
		}
	}
}