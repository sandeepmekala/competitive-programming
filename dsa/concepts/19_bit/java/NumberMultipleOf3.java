public class NumberMultipleOf3 {

	public static void main(String[] args) {
		NumberMultipleOf3 obj = new NumberMultipleOf3();

		int n = 7;
		System.out.println(obj.isMultipleOf3(n));
	}

	// Problem: https://www.geeksforgeeks.org/write-an-efficient-method-to-check-if-a-number-is-multiple-of-3/
	// Idea: In decimal form this number will be:  2^{4} * a  +  2^{3} * b  +  2^{2} * c  +  2^{1} * d  +  2^{0} * e
	// Every even power of 2 can be represented as 3n + 1, and every odd power of 2 can be represented as 3n – 1.
	// term (a + c + e) - (b + d) should be divisible by 3 if we take 3n out
	public boolean isMultipleOf3(int n) {
		if(n < 0) n = -1*n;

		if(n == 0)
			return true;
		if(n == 1 || n == 2)
			return false;

		int oddBitCount = 0;
		int evenBitCount = 0;
		while(n != 0) {
			if((n&1) == 1) {
				oddBitCount++;
			}
			n = n>>1;
			if((n&1) == 1) {
				evenBitCount++;
			}
			n = n>>1;
		}

		if(isMultipleOf3(oddBitCount - evenBitCount))
			return true;

		return false;
	}

}
