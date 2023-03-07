package edu.algos.li02_array;

import java.util.Arrays;

public class _L88_MergeSortedArray {

	public static void main(String[] args) {
		_L88_MergeSortedArray obj = new _L88_MergeSortedArray();
		
		int[] nums1 = new int[] {1,2,3,0,0,0};
		int m = 3;
		int[] nums2 = new int[] {2,5,6};
		int n = 3;
		
		obj.merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}
	
    // Problem: https://leetcode.com/problems/merge-sorted-array/
    // Idea: Start merging from backwords

    // Incase two arrays without empty space and you need to inplace sorting. Use gap algo. Run 2 ptrs with the gap dist and swap them if not in order. 
    // If any of the ptr goes out of second array stop and reduce the gap.
    // gap = 6/2 = 3
    // gap = 3/2 = 2
    // gap = 2/2 = 1
    // Alternatively, you can use insertion sort kind of algorithm to sort inplace.
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
        while(i>=0){
            nums1[k--] = nums1[i--];
        }
        while(j>=0){
            nums1[k--] = nums2[j--];
        }
        
    }

}
