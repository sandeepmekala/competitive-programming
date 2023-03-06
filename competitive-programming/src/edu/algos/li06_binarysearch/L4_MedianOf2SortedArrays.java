package edu.algos.li06_binarysearch;

public class L4_MedianOf2SortedArrays {

	public static void main(String[] args) {
		L4_MedianOf2SortedArrays obj = new L4_MedianOf2SortedArrays();
		int nums1[] = {1,3};
		int nums2[] = {2};
        
        System.out.println(obj.findMedianSortedArrays(nums1, nums2));
        
	}	
	
	/*
	 * Problem: https://leetcode.com/problems/median-of-two-sorted-arrays/
	 * Idea: The goal is to divide the arrays into two equal halfs using binary search. 
	 * Once you are able to divide the arrays, you can find the median easily using last and first elements of equal halfs.
	 * To divide the array into two equal halfs, find the middle of first array and subtract it from half to get the middle of second array as midian is always sits in the half of full array
	 * Once arrays are divided, check n1left, n1right, n2left, n2right elements to see if arrays are divided properly, if not, accordingly shift l or r pointers to redivide the arrays
	 * 
	 * */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m=nums1.length, n=nums2.length;
		if(n>m)
			return findMedianSortedArrays(nums2,nums1);	// ensuring that binary search happens on minimum size array
			
		int low=0, high=m, mid=(m+n+1)/2;	// +1 to hand even and odd total lens
		while(low<=high) {
			int cut1 = (low+high)>>1;
			int cut2 = mid - cut1;
			
			int l1 = (cut1 == 0)? Integer.MIN_VALUE:nums1[cut1-1];
			int l2 = (cut2 == 0)? Integer.MIN_VALUE:nums2[cut2-1];
			int r1 = (cut1 == m)? Integer.MAX_VALUE:nums1[cut1];
			int r2 = (cut2 == n)? Integer.MAX_VALUE:nums2[cut2];
			
			if(l1<=r2 && l2<=r1) {
				if((m+n)%2 != 0)
					return Math.max(l1,l2);
				else 
					return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
			}else if(l1>r2) high = cut1-1;
			else low = cut1+1;
		}
		return 0.0;
	}

}
