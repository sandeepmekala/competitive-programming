
public class MultiplyBy7 {

	public static void main(String[] args) {
		MultiplyBy7 obj = new MultiplyBy7();

		int n = 2;
		System.out.println(obj.multiplyBy7(n));
	}

	// Idea: Similar like 3 is closely associated with 2, 7 is closely assiciated to 8.
	// Multiplying n by 7 means, 7n = 8n-n
	// 8 -> 2^3 which we can get by left shifting 3 times.
	public int multiplyBy7(int n) {
		return ((n<<3) - n);
	}
}
