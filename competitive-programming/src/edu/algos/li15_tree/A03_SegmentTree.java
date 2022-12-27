package edu.algos.li15_tree;

import java.util.Arrays;

public class A03_SegmentTree {

	public static void main(String[] args) {
		A03_SegmentTree obj = new A03_SegmentTree();

		int[] input = new int[] {-1, 2, 4, 0};
		int segTreeSize = (int)Math.pow(2, input.length-1)-1; 
		int[] segTree = new int[segTreeSize];	
		Arrays.fill(segTree, Integer.MAX_VALUE);
		
		obj.constructTree(input, segTree, 0, input.length-1, 0);
		
		System.out.println(Arrays.toString(segTree));
		
		System.out.println(obj.rangeMinQuery(segTree, 0, 3, 0, input.length-1, 0));
	}
	
	// Note: Provides min, max and sum in a given range efficiently in logn time
	// Similar like heap, even gets stored in array physically, it is a tree where each root is min of its childs.
	// Seg Tree array len = 2^(n-1)-1     4 -> 4*2 - 1 = 7. If length=5 -> 8*2-1 = 16
	// ith node parent will be at (i-1)/2
	// Left of ith child child will be at (2*i+1)/2
	// Right child will be at (2*i+2)/2
	// https://www.youtube.com/watch?v=ZBHKZF5w4YU

	// Idea: Root of the segment tree is placed at index 0 in array. So start position as 0 for the root.
	// Pass the pos of left and right childs to recursively build left and right subtrees to place conrresponding values in those positions.
	// After recursion of both the child and childs are placed in their places. Parent is min of its both childs.
	// O(n)
	private void constructTree(int[] input, int[] segTree, int low, int high, int pos) {
		if(low == high) {
			segTree[pos] = input[low];
			return;
		}

		int mid = (low+high)/2;
		constructTree(input, segTree, low, mid, 2*pos+1);		//pass the pos of left child
		constructTree(input, segTree, mid+1, high, 2*pos+2);	//pass the pos of right child
		segTree[pos] = Math.min(segTree[2*pos+1], segTree[2*pos+2]); // Once the childs are placed in their place. Parent is min of its both childs.
	}
	
	// Idea: Three cases need to handled
	// Query range overlapping with root range: If the tree root range is inside the query range return its value. [2,3] is inside of q[2,4].
	// Query range not Overlapping with root range: If no overlap, return some max value so that min never gets that value. [5,5] is not inside of q[2,4].
	// Query range partially overlapping with root range: If tree root range beyand the boundaries of query, you need to find some minimal spacific range. Hence search in both subtrees. [0, 5] is beyand q[2,4].
	// O(log(n))
	private int rangeMinQuery(int[] segTree, int qlow, int qhigh, int low, int high, int pos) {
		if(qlow<= low && qhigh >= high) { //overlapping
			return segTree[pos];
		}else if(qhigh < low || qlow > high) {	// no overlapping
			return Integer.MAX_VALUE;
		}else {
			int mid = (low+high)/2;
			int left = rangeMinQuery(segTree, qlow, qhigh, low, mid, 2*pos+1);
			int right = rangeMinQuery(segTree, qlow, qhigh, mid+1, high, 2*pos+2);
			return Math.min(left, right);		//for [2,3], we meed to take min of [2,2] and [3,3]
		}
		
	}
}
