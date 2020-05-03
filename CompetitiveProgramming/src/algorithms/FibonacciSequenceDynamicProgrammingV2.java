package algorithms;
import java.util.ArrayList;

public class FibonacciSequenceDynamicProgrammingV2 {

	public static void main(String[] args) {
		
		System.out.println(fib(1));
	}
	private static int fib(int n){

		int first = 1;
		int second = 1;
		
		if(n<=2)
			return 1;
		
		for(int i=2; i<n; i++){
			int temp;
			temp = first;
			first = second;
			second = temp + first;
		}

		return second;
		
	}

}
