import java.util.Arrays;

public class SegmentTree {

	public static void main(String[] args) {
		SegmentTree obj = new SegmentTree();

		int[] nums = new int[] {-1, 2, 4, 0};
		int n = nums.length;

		int[] seg = obj.build(nums, n);

		System.out.println(Arrays.toString(seg));

		System.out.println(obj.queryRangeMin(seg, 0, 0, n-1, 0, 2));
		obj.updatePointSum(seg, 0, 0, n-1, 0, 3);
		System.out.println(obj.queryRangeMin(seg, 0, 0, n-1, 0, 2));

	}

	// Note: Provides min, max and sum in a given range efficiently in log(n) time
	// Similar like heap, even gets stored in array physically, it is a tree where each root is min of its childs.
	// Seg Tree array len = 2^(n-1)-1     4 -> 4*2 - 1 = 7. If length=5 -> 8*2-1 = 16
	// ith node parent will be at (i-1)/2
	// Left child: 2*i+1
	// Right child: 2*i+2
	// https://www.youtube.com/watch?v=-dUiRtJ8ot0

	// Idea: Root of the segment tree is placed at index 0 in array. So start ind as 0 for the root.
	// Pass the ind of left and right childs to recursively build left and right subtrees to place conrresponding values in those indices.
	// After recursion of both the child and childs are placed in their places. Parent is min of its both childs.
	// O(n)
	public int[] build(int[] nums, int n) {
		int size = (int)Math.pow(2, n-1)-1;
		int[] seg = new int[size];
		Arrays.fill(seg, Integer.MAX_VALUE);

		build(nums, seg, 0, 0, n-1);
		return seg;
	}

	private void build(int[] nums, int[] seg, int ind, int low, int high) {
		if(low == high) {
			seg[ind] = nums[low];
			return;
		}

		int mid = (low+high)/2;
		build(nums, seg, 2*ind+1, low, mid);		//pass the pos of left child
		build(nums, seg, 2*ind+2, mid+1, high);		//pass the pos of right child
		seg[ind] = Math.min(seg[2*ind+1], seg[2*ind+2]); // Once the childs are placed in their place. Parent is min of its both childs.
	}

	// Idea: Three cases need to be handled
	// Query range overlapping with root range: If the tree root range is inside the query range return its value. [2,3] is inside of q[2,4].
	// Query range not Overlapping with root range: If no overlap, return some max value so that min never gets that value. [5,5] is not inside of q[2,4].
	// Query range partially overlapping with root range: If tree root range beyand the boundaries of query, you need to find some minimal spacific range. Hence search in both subtrees. [0, 5] is beyand q[2,4].
	// O(log(n))
	private int queryRangeMin(int[] segTree, int ind, int low, int high, int ql, int qr) {
		if(low >= ql && high <= qr ) 	// node overlapping
			return segTree[ind];

		if(low > qr || high < ql) 	// node not overlapping
			return Integer.MAX_VALUE;
									// node partially overlapping
		int mid = (low+high)/2;
		int left = queryRangeMin(segTree, 2*ind+1, low, mid, ql, qr);
		int right = queryRangeMin(segTree, 2*ind+2, mid+1, high, ql, qr);

		return Math.min(left, right);		//for [2,3], we meed to take min of [2,2] and [3,3]
	}

	// This is fine for a single point update. What if we want to update a range of values?
	// This is where lazy propagation comes into play. We can update the range in O(log(n)) time.
	// https://www.youtube.com/watch?v=rwXVCELcrqU
	// Time: O(log(n))
	public void updatePointSum(int[] segTree, int ind, int low, int high, int index, int value) {
		if(low == high) {
			segTree[ind] += value;
			return;
		}

		int mid = (low+high)/2;
		if(index <= mid) {
			updatePointSum(segTree, 2*ind+1, low, mid, index, value);
		} else {
			updatePointSum(segTree, 2*ind+2, mid+1, high, index, value);
		}

		segTree[ind] = Math.min(segTree[2*ind+1], segTree[2*ind+2]);
	}

	public void updateRangeSumLazy(int[] seg, int[] lazy, int ind, int low, int high, int ql, int qr, int value) {
		if(lazy[ind] != 0){				// add lazy tree value to current node
			seg[ind] += (high - low + 1)*lazy[ind];
			if(low != high){
				lazy[2*ind+1] += lazy[ind];
				lazy[2*ind+2] += lazy[ind];
			}
			lazy[ind] = 0;
		}

		if(low > qr || high < ql) 		// node not overlapping
			return;

		if(low >= ql  && high <= qr) {	// node overlapping
			seg[ind] += (high - low + 1)*value;
			if(low != high){
				lazy[2*ind+1] += value;	// don't update the child nodes. Just update the lazy tree.
				lazy[2*ind+2] += value;
			}
			return;
		}

		int mid = (low+high)/2;
		updateRangeSumLazy(seg, lazy, 2*ind+1, low, mid, ql, qr, value);
		updateRangeSumLazy(seg, lazy, 2*ind+2, mid+1, high, ql, qr, value);

		seg[ind] = Math.min(seg[2*ind+1], seg[2*ind+2]);
	}

	public int queryRangeSumLazy(int[] seg, int[] lazy, int ind, int low, int high, int l, int r) {
		if(lazy[ind] != 0){				// add lazy tree value to current node
			seg[ind] += (high - low + 1)*lazy[ind];
			if(low != high){
				lazy[2*ind+1] += lazy[ind];
				lazy[2*ind+2] += lazy[ind];
			}
			lazy[ind] = 0;
		}

		if(low > r || high < l) 		// node not overlapping
			return 0;

		if(low >= l  && high <= r) {	// node overlapping
			return seg[ind];
		}

		int mid = (low+high)/2;
		int left = queryRangeSumLazy(seg, lazy, 2*ind+1, low, mid, l, r);
		int right = queryRangeSumLazy(seg, lazy, 2*ind+2, mid+1, high, l, r);
		return left + right;
	}
}
