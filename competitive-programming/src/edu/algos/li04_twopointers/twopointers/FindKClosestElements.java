package edu.algos.li04_twopointers.twopointers;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

	public static void main(String[] args) {
		FindKClosestElements obj = new FindKClosestElements();
		
		int[] arr = new int[] {1,2,3,4,5};
		System.out.println(obj.findClosestElements(arr, 4, 3));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/find-k-closest-elements/
	 * Companies: Amazon
	 * */
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int closest = -1, n = arr.length;
        if(x < arr[0]) closest = 0;
        else if(x > arr[n-1]) closest = n-1;
        else closest = search(arr, x);
        System.out.println(arr[closest]);
        
        List<Integer> result = new ArrayList<>();
        int i = closest, j=closest+1;
        while(k>0){
            int temp1 = (i>=0)? Math.abs(arr[i] - x) : Integer.MAX_VALUE;
            int temp2 = (j<n)? Math.abs(arr[j] - x)  : Integer.MAX_VALUE;;
            if(temp1 <= temp2){
                result.add(0, arr[i--]);
            }else{
                result.add(arr[j++]);
            }
            k--;
        }
        
        return result;
    }
    
    private int search(int[] arr, int x){
        int start=0, end = arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid] == x){
                return mid;
            }else if(arr[mid] < x){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        
        int temp1 = Math.abs(arr[end] - x);
        int temp2 = Math.abs(arr[start] - x);
        return temp1<=temp2? end: start;
    }

}
