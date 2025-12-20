import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		BubbleSort bsort = new BubbleSort();
		int[] numbers = {2,7,4,1,5,3};
		System.out.println(Arrays.toString(numbers));
		bsort.bubbleSort(numbers);

	}

	// Idea: The biggest element is bubbled to last one for each iteration
	// Time complexity in worst & average case is O(n^2). Best case O(n)
	// Stable sorting
	// Inplace sorting.
	public void bubbleSort(int[] numbers) {
		for(int i=0; i<numbers.length; i++){
			boolean sorted = true;
			for(int j=0; j<numbers.length-1; j++){
				if(numbers[j] > numbers[j+1]){
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;

					sorted = false;
				}
			}
			if(sorted){
				break;
			}
			System.out.println(Arrays.toString(numbers));
		}

	}

}
