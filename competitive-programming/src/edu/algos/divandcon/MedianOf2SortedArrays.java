package edu.algos.divandcon;

public class MedianOf2SortedArrays {

	public static void main(String[] args) {
		MedianOf2SortedArrays obj = new MedianOf2SortedArrays();
		int nums1[] = {3};
		int nums2[] = {-2,-1};
        
        System.out.println(obj.getMedian(nums1, nums2));
        
	}
	
	private double getMedian(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
        int n2 = nums2.length;
        
        if(n1 == 0 && n2 == 1) {
        	return nums2[0];
        }else if(n1 == 1 && n2 == 0) {
        	return nums1[0];
        }else if(n1 == 0 && n2 == 2) {
        	return ((nums2[0]+nums2[1])/2.0);
        }else if(n1 == 2 && n2 == 0) {
        	return ((nums1[0]+nums1[1])/2.0);
        }else if(n1 == 1 && n2 == 1) {
        	return ((nums1[0]+nums2[0])/2.0);
        } else {
        	return getMedian(nums1, nums2, 0, 0, n1-1, n2-1);
        }
	}

	//concept: find the medians of respective arrays and compare the medians, recursively reduce the search space to 2 elements in each array
	private double getMedian(int[] nums1, int[] nums2, int start1, int start2, int end1, int end2) {

		if(end1 - start1 == 1) {
			return (Math.max(nums1[start1], nums2[start2])+Math.min(nums1[end1], nums2[end2]))/2.0;
		}
		int m1 = this.median(nums1, start1, end1);
		int m2 = this.median(nums2, start2, end2);
		System.out.println(m1+":"+m2);
		if(m1 == m2) {
			return m1;
		}else if(m1 < m2){
			return getMedian(nums1, nums2, (start1+end1+1)/2, start2, end1, (start2+end2+1)/2);
		}else {
			return getMedian(nums1, nums2, start1, (start2+end2+1)/2, (start1+end1+1)/2, end2);
		}
		
	}

	private int median(int[] arr, int start, int end) {
		int n = end - start + 1;
		if(n%2 == 0) {
			return (arr[start+n/2]+arr[start+n/2-1])/2;		//[1, 2] -> n = 2-0+1 = 2, n/2=1, n/2-1=0
		}else {
			return arr[start+n/2];
		}
	}

}
