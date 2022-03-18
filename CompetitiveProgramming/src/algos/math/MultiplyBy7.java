package algos.math;

public class MultiplyBy7 {

	public static void main(String[] args) {
		int n = 3;
		System.out.println(multiplyBy7(n));
	}

	private static int multiplyBy7(int n) {
		
		return ((n<<3) - n);
	}

}
