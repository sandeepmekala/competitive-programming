package edu.algos.li11.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		SlidingWindowMaximum obj = new SlidingWindowMaximum();
		
		int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int[] result = obj.maxSlidingWindow(nums, k);
		System.out.println(Arrays.toString(result));
	}
	
	/*
	 * Problem: get max of each sliding window
	 * Concept: Maintain the nums in decreasing order in queue take the left most to take the max for that window
	 * remove the left most if it goes out of window
	 * 
	 * Use, monotonically decreasing queue
	 * 
	 * */

	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] result = new int[n-k+1];
		
		int l=0, r=0, ind=0;
		Deque<Integer> dq = new ArrayDeque<>();				//indices
		while(r<n) {
			while(!dq.isEmpty() && nums[dq.peekLast()] < nums[r]) {
				dq.removeLast();
			}
			
			dq.add(r);
			if(dq.peekFirst() < l) {
				dq.removeFirst();
			}
			
			if(r-l+1 >= k) {
				result[ind++] = nums[dq.peekFirst()];
				l++;
			}
			r++;
		}
		
		return result;
	}

}
