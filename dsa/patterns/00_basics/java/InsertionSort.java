import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		InsertionSort isort = new InsertionSort();
		int[] numbers = {2,7,4,1,5,3};
		System.out.println(Arrays.toString(numbers));
		isort.inertionnSort(numbers);
	}

	// Idea: Treat left array as sorted. Move the current element to its correct position in sorted array by shifting elements to right.
	// Time complexity is worst & average case O(n^2). Best case O(n) if array is already sorted.
	// Stable sorting
	// Space complexity is O(1). Means Inplace sorting.
	public void inertionnSort(int[] nums) {
		for(int i=1; i<nums.length;i++){
			int curr = nums[i];
			int j = i;
			while(j > 0 && nums[j-1] > curr){
				nums[j] = nums[j-1];
				j--;
			}
			nums[j] = curr;
			System.out.println(Arrays.toString(nums));
		}
	}
}
