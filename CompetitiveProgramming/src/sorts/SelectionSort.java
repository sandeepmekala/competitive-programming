package sorts;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] numbers = {2,7,4,1,5,3};					//time complexity is O(n^2)
		System.out.println(Arrays.toString(numbers));
		selectionSort(numbers);							//non-stable sorting
														//space complexity is O(1). Means Inplace sorting.
	}

	private static void selectionSort(int[] numbers) {
		for(int i=0; i<numbers.length-1; i++){
			int imin = i;
			for(int j=i+1; j<numbers.length; j++){
				if(numbers[j] < numbers[imin]){
					imin = j;
				}
			}
			int temp = numbers[imin];
			numbers[imin] = numbers[i];
			numbers[i] = temp;
			System.out.println(Arrays.toString(numbers));
		}		
	}

}
