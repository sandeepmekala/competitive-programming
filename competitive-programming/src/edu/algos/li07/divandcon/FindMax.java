package edu.algos.li07.divandcon;

public class FindMax {

	public static void main(String[] args) {
		int numbers[] = { 70, 250, 50, 80, 140, 12, 14 };
		System.out.println(findMax(numbers, 0, numbers.length));
	}
	
	//this is DC becuase we are dividing the problem into smaller sub problems and find solution to them and the finding the solution to bigger problem by from the smaller problem
	private static int findMax(int[] numbers, int index, int n) {
		
		// this make sure it stops at last but one index
		if(index >= n-2) {
			if(numbers[index] > numbers[index+1]) {
				return numbers[index];
			}else {
				return numbers[index+1];
			}
		}
		
		int max = findMax(numbers, index+1, n);
		
		if(numbers[index] > max) {
			return numbers[index];
		}else {
			return max;
		}
	}
}
