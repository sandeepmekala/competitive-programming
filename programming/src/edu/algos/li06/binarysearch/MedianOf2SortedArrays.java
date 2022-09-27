package edu.algos.li06.binarysearch;

public class MedianOf2SortedArrays {

	public static void main(String[] args) {
		MedianOf2SortedArrays obj = new MedianOf2SortedArrays();
		int nums1[] = {1,3};
		int nums2[] = {2};
        
        System.out.println(obj.findMedianSortedArrays(nums1, nums2));
        
	}
	
	/*
	 * Concept: the goal is to divide the arrays into two equal halfs using binary search. 
	 * Once you are able to divide the arrays, you can find the median easily using last and first elements of equal halfs
	 * 
	 * to divide the array into two equal halfs, find the middle of first array and subtract it from half to get the middle of second array as midian as always sits in the half of full array
	 * once arrays are divided check n1left, n1right, n2left, n2right elements to see if arrays are divided properly, if not accordingly shift l or r pointers to redivide the arrays
	 * 
	 * */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		if (nums1.length > nums2.length){		// run bs on min array to reduce the time
			int[] temp = nums2;
			nums2 = nums1;
			nums1 = temp;			
		}
		
		int n1 = nums1.length, n2 = nums2.length;		
		int total = n1+n2, half = (n1+n2)/2;
		int l=0, r=n1-1;
		while(true) {
			int m1 = (int) Math.floor((l+r)/2.0);
			int m2 = half-m1-2;
			int n1left, n1right, n2left, n2right;
			
			n1left = (m1 >= 0)?nums1[m1]:Integer.MIN_VALUE;
			n1right = (m1+1 < n1)?nums1[m1+1]:Integer.MAX_VALUE;
			n2left = (m2 >= 0)?nums2[m2]:Integer.MIN_VALUE;
			n2right = (m2+1 < n2)?nums2[m2+1]:Integer.MAX_VALUE;
			if(n1left <= n2right && n2left <= n1right) {
				if(total % 2 == 1) {
					return Math.min(n1right, n2right);
				}else {
					return (Math.max(n1left, n2left) + Math.min(n1right, n2right))/2.0;
				}
			}else if(n1left > n2right) {
				r = m1-1;
			}else {
				l = m1+1;
			}
			
		}
	}

}
