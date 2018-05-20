package sorts;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] numbers = {5,2,6,8,5,9,1};				//time complexity is O(n^2)
		selectionSort(numbers);							//stable sorting
		System.out.println(Arrays.toString(numbers));	//space complexity is O(1). Means Inplace sorting.
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
		}		
	}

}
