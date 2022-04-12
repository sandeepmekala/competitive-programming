package edu.algos.divandcon;

public class MedianOf2SortedArrays {

	public static void main(String[] args) {
		int arr1[] = {1, 2, 3, 4, 5};
		int arr2[] = {6, 7, 8, 9, 10};
        int n1 = arr1.length;
        int n2 = arr1.length;
        
        if(n1 == 0) {
        	System.out.println(-1);
        }else if(n1 == 1) {
        	System.out.println((arr1[0]+arr2[0])/2);
        } else {
        	System.out.println(getMedian(arr1, arr2, 0, 0, n1-1, n2-1));
        }
        
	}

	//concept: find the medians of respective arrays and compare the medians, recursively reduce the search space to 2 elements in each array
	private static double getMedian(int[] arr1, int[] arr2, int start1, int start2, int end1, int end2) {

		if(end1 - start1 == 1) {
			return (Math.max(arr1[start1], arr2[start2])+Math.min(arr1[end1], arr2[end2]))/2.0;
		}
		int m1 = median(arr1, start1, end1);
		int m2 = median(arr2, start2, end2);
		System.out.println(m1+":"+m2);
		if(m1 == m2) {
			return m1;
		}else if(m1 < m2){
			return getMedian(arr1, arr2, (start1+end1+1)/2, start2, end1, (start2+end2+1)/2);
		}else {
			return getMedian(arr1, arr2, start1, (start2+end2+1)/2, (start1+end1+1)/2, end2);
		}
		
	}

	private static int median(int[] arr, int start, int end) {
		int n = end - start + 1;
		if(n%2 == 0) {
			return (arr[start+n/2]+arr[start+n/2-1])/2;		//[1, 2] -> n = 2-0+1 = 2, n/2=1, n/2-1=0
		}else {
			return arr[start+n/2];
		}
	}

}
