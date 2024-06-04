package  com.algos.core.li05_binarysearch.revised;

public class L4_MedianOf2SortedArrays {

	public static void main(String[] args) {
		L4_MedianOf2SortedArrays obj = new L4_MedianOf2SortedArrays();
		int nums1[] = {1,3};
		int nums2[] = {2};						// 2.0
        
        System.out.println(obj.findMedianSortedArrays(nums1, nums2));
        
	}	
	
	// Problem: https://leetcode.com/problems/median-of-two-sorted-arrays/
	// Idea: The goal is to divide the arrays into two equal halfs using BS. 
	// Once you are able to divide the arrays, you can find the median easily using last and first elements of equal halfs.
	// To divide the array into two equal halfs, find the middle of first array and subtract it from half to get the middle of second array as midian is always sits in the half of full array
	// Once arrays are divided, check l1, r1, l2, r2 elements to see if arrays are divided properly, if not, accordingly shift l or r pointers to redivide the arrays
	// BS range is from 0 to n1, means we can take min 0 elts and max n1 els from first array
	// Time: O(log(min(n1,n2))) 
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1=nums1.length, n2=nums2.length;
		if(n1 > n2)
			return findMedianSortedArrays(nums2, nums1);	// ensuring that binary search happens on minimum size array
			
		int n = n1+n2;
		int low=0, high=n1, left=(n+1)/2;					// +1 to handle even and odd total lens
		while(low <= high) {
			int mid1 = (low+high) / 2;						// Taking mid1 els from first array
			int mid2 = left - mid1;							// Taking mid2 els from second array
			
			int l1 = (mid1 == 0)? Integer.MIN_VALUE:nums1[mid1-1];
			int l2 = (mid2 == 0)? Integer.MIN_VALUE:nums2[mid2-1];
			int r1 = (mid1 == n1)? Integer.MAX_VALUE:nums1[mid1];
			int r2 = (mid2 == n2)? Integer.MAX_VALUE:nums2[mid2];
			
			if(l1<=r2 && l2<=r1) {
				if(n%2 == 1)
					return Math.max(l1,l2);
				else 
					return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
			}else if(l1>r2) high = mid1-1;
			else low = mid1+1;
		}

		return 0.0;
	}

}
