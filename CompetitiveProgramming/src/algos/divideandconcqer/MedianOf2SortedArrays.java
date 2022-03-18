package algos.divideandconcqer;

public class MedianOf2SortedArrays {

	public static void main(String[] args) {
		int arr1[] = {1, 12, 15, 26, 38};
		int arr2[] = {2, 13, 17, 30, 45};
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
	private static int getMedian(int[] arr1, int[] arr2, int startArr1, int startArr2, int endArr1, int endArr2) {

		if(endArr1 - startArr1 == 1) {
			return (Math.max(arr1[startArr1], arr2[startArr1])+Math.min(arr1[endArr2], arr2[endArr2]))/2;
		}
		int m1 = median(arr1, startArr1, endArr1);
		int m2 = median(arr2, startArr2, endArr2);
		System.out.println(m1+":"+m2);
		if(m1 == m2) {
			return m1;
		}else if(m1 < m2){
			return getMedian(arr1, arr2, (startArr1+endArr1+1)/2, startArr2, endArr1, (startArr2+endArr2+1)/2);
		}else {
			return getMedian(arr1, arr2, startArr1, (startArr2+endArr2+1)/2, (startArr1+endArr1+1)/2, endArr2);
		}
		
	}

	private static int median(int[] arr1, int startArr1, int endArr1) {
		int n = endArr1 - startArr1 + 1;
		if(n%2 == 0) {
			return (arr1[startArr1+n/2]+arr1[startArr1+n/2-1])/2;
		}else {
			return arr1[startArr1+n/2];
		}
	}

}
