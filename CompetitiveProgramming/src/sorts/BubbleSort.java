package sorts;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] numbers = {1, 2, 5, 5, 6, 8, 9};				//time complexity is worst & avenrage case O(n^2). Best case O(n)
		bubbleSort(numbers);							//stable sorting
		System.out.println(Arrays.toString(numbers));	//space complexity is O(1). Means Inplace sorting.
	}

	private static void bubbleSort(int[] numbers) {
		for(int i=0; i<numbers.length-1; i++){
			boolean sorted = true;
			for(int j=0; j<numbers.length-1; j++){
				if(numbers[j] > numbers[j+1]){
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] =temp;
					
					sorted = false;
				}
			}
			if(sorted){
				break;
			}
		}
		
	}

}
