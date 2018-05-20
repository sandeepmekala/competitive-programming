package sorts;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] numbers = {2,7,4,1,5,3};					//time complexity is worst & average caseO(n^2). best case O(n)
		System.out.println(Arrays.toString(numbers));	
		inertionnSort(numbers);							//stable sorting
														//space complexity is O(1). Means Inplace sorting.
	}

	private static void inertionnSort(int[] numbers) {
		
		for(int i=1; i<numbers.length;i++){
			int value = numbers[i];
			int hole = i;
			while(hole > 0 && numbers[hole-1] > value){
				numbers[hole] = numbers[hole-1];
				hole--;
			}
			numbers[hole] = value;
			System.out.println(Arrays.toString(numbers));
		}
	}
}
