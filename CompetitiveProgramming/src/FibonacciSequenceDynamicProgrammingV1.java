import java.util.ArrayList;

public class FibonacciSequenceDynamicProgrammingV1 {

	public static void main(String[] args) {
		
		System.out.println(fib(25));
	}
	private static int fib(int n){

		int nums[] = new int[n];
		nums[0] = 1;
		nums[1] = 1;
		if(n>2){
			for(int i=2; i<=n-1; i++){
				nums[i] = nums[i-1] + nums[i-2];
			}
		}

		return nums[n-1];
	}

}
