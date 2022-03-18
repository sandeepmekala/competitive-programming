package algos.math;

public class SqrtOfX {

	public static void main(String[] args) {
		int input = 24;
		System.out.println(sqrtOfX(input));
	}

	private static int sqrtOfX(int input) {
		int sqrt = -1;
		int start = 0, end = input; 
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(mid <= input/mid) {
				sqrt = mid;
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return sqrt;
	}

}
