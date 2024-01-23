package  com.algos.li06_binarysearch;

public class L69_SqrtOfX {

	public static void main(String[] args) {
		L69_SqrtOfX obj = new L69_SqrtOfX();
		int input = 8;
		System.out.println(obj.sqrtOfX(input));
	}

	private int sqrtOfX(int input) {
        if(input == 0 || input == 1){
            return input;
        }
        
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
