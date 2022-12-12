package edu.algos.li01_array.easy;

import java.util.Arrays;

public class L88_MergeSortedArray {

	public static void main(String[] args) {
		L88_MergeSortedArray obj = new L88_MergeSortedArray();
		
		int[] nums1 = new int[] {1,2,3,0,0,0};
		int m = 3;
		int[] nums2 = new int[] {2,5,6};
		int n = 3;
		
		obj.merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}
	
    // Problem: https://leetcode.com/problems/merge-sorted-array/
    // Idea: Start mergin from backwords
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
