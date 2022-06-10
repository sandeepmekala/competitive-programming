package edu.algos.math;

public class SqrtOfX {

	public static void main(String[] args) {
		SqrtOfX obj = new SqrtOfX();
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
