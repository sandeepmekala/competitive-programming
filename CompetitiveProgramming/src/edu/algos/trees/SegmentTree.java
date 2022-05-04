package edu.algos.trees;

import java.util.Arrays;

public class SegmentTree {

	public static void main(String[] args) {
		int[] input = new int[] {-1, 2, 4, 0};
		int[] segTree = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};	// length=2^(n-1)-1     4 -> 4*2 - 1 = 7. If length=5 -> 8*2-1 = 16
		
		constrcutTree(input, segTree, 0, input.length-1, 0);
		
		System.out.println(Arrays.toString(segTree));
		
		System.out.println(rangeMinQuery(segTree, 0, 3, 0, input.length-1, 0));
	}
	
	//  Concept: Provides min in given range efficiently
	// O(n)
	private static void constrcutTree(int[] input, int[] segTree, int low, int high, int pos) {
		if(low == high) {
			segTree[pos] = input[low];
			return;
		}
		int mid = (low+high)/2;
		constrcutTree(input, segTree, low, mid, 2*pos+1);
		constrcutTree(input, segTree, mid+1, high, 2*pos+2);
		segTree[pos] = Math.min(segTree[2*pos+1], segTree[2*pos+2]);
	}
	
	// O(log(n))
	private static int rangeMinQuery(int[] segTree, int qlow, int qhigh, int low, int high, int pos) {
		if(qlow<= low && qhigh >= high) { //overlapping: q[2,4] overlaps with [3,4]
			return segTree[pos];
		}else if(qhigh < low || qlow > high) {	// no overlapping: q[2,4] is not overlapping with [5,5]
			return Integer.MAX_VALUE;
		}else {
			int mid = (low+high)/2;
			int left = rangeMinQuery(segTree, qlow, qhigh, low, mid, 2*pos+1);
			int right = rangeMinQuery(segTree, qlow, qhigh, mid+1, high, 2*pos+2);
			return Math.min(left, right);
		}
		
	}
}
