package com.algos.topics.li04_twopointers.revised;

import java.util.ArrayList;
import java.util.List;

public class FindtheIntersectionOfTwoSortedArrays {

        public static void main(String[] args) {
            FindtheIntersectionOfTwoSortedArrays obj = new FindtheIntersectionOfTwoSortedArrays();
            int[] nums1 = { 1, 2, 3, 4, 5 };
            int[] nums2 = { 1, 2, 3 };
            System.out.println(obj.findIntersection(nums1, nums2));
        }

        // Problem: Find the intersection of two sorted arrays
        public List<Integer> findIntersection(int[] nums1, int[] nums2){
            int n1 = nums1.length, n2 = nums2.length;
            int i=0, j=0;
            List<Integer> intersection = new ArrayList<>();
            while(i<n1 && j<n2){
                if(nums1[i] == nums2[j]){
                    intersection.add(nums1[i]);
                    i++;
                    j++;
                }else if(nums1[i] < nums2[j]){
                    i++;
                }else{
                    j++;
                }
            }

            return intersection;
        }
}
