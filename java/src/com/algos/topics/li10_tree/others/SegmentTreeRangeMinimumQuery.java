package com.algos.topics.li10_tree.others;

import java.util.Arrays;

public class SegmentTreeRangeMinimumQuery {

    /**
     * Creates a new segment tree based off nums array.
     */
    public int[] createSegmentTree(int[] nums){
        int n = nums.length;
        int size = (int)Math.pow(2, n-1)-1;
        int[] seg = new int[size];
        Arrays.fill(seg, Integer.MAX_VALUE);

        constructMinSegmentTree(seg, nums, 0, nums.length - 1, 0);
        return seg;

    }

    /**
     * Updates segment tree for certain index by given delta
     */
    public void updateSegmentTree(int[] nums, int[] seg, int index, int delta){
        nums[index] += delta;
        updateSegmentTree(seg, index, delta, 0, nums.length - 1, 0);
    }

    /**
     * Updates segment tree for given range by given delta
     */
    public void updateSegmentTreeRange(int[] nums, int[] seg, int startRange, int endRange, int delta) {
        for(int i = startRange; i <= endRange; i++) {
            nums[i] += delta;
        }
        updateSegmentTreeRange(seg, startRange, endRange, delta, 0, nums.length - 1, 0);
    }

    /**
     * Queries given range for minimum value.
     */
    public int rangeMinimumQuery(int []seg,int qlow,int qhigh,int len){
        return rangeMinimumQuery(seg,0,len-1,qlow,qhigh,0);
    }

    /**
     * Updates given range by given delta lazily
     */
    public void updateSegmentTreeRangeLazy(int[] nums, int[] seg, int[] lazy, int startRange, int endRange, int delta) {
        updateSegmentTreeRangeLazy(seg, lazy, startRange, endRange, delta, 0, nums.length - 1, 0);
    }

    /**
     * Queries given range lazily
     */
    public int rangeMinimumQueryLazy(int[] seg, int[] lazy, int qlow, int qhigh, int len) {
        return rangeMinimumQueryLazy(seg, lazy, qlow, qhigh, 0, len - 1, 0);
    }

    private void constructMinSegmentTree(int[] seg, int[] nums, int low, int high,int pos){
        if(low == high){
            seg[pos] = nums[low];
            return;
        }
        int mid = (low + high)/2;
        constructMinSegmentTree(seg, nums, low, mid, 2 * pos + 1);
        constructMinSegmentTree(seg, nums, mid + 1, high, 2 * pos + 2);
        seg[pos] = Math.min(seg[2*pos+1], seg[2*pos+2]);
    }

    private void updateSegmentTree(int[] seg, int index, int delta, int low, int high, int pos){

        //if index to be updated is less than low or higher than high just return.
        if(index < low || index > high){
            return;
        }

        //if low and high become equal, then index will be also equal to them and update
        //that value in segment tree at pos
        if(low == high){
            seg[pos] += delta;
            return;
        }
        //otherwise keep going left and right to find index to be updated
        //and then update current tree position if min of left or right has
        //changed.
        int mid = (low + high)/2;
        updateSegmentTree(seg, index, delta, low, mid, 2 * pos + 1);
        updateSegmentTree(seg, index, delta, mid + 1, high, 2 * pos + 2);
        seg[pos] = Math.min(seg[2*pos+1], seg[2*pos + 2]);
    }

    private void updateSegmentTreeRange(int[] seg, int startRange, int endRange, int delta, int low, int high, int pos) {
        if(low > high || startRange > high || endRange < low ) {
            return;
        }

        if(low == high) {
            seg[pos] += delta;
            return;
        }

        int middle = (low + high)/2;
        updateSegmentTreeRange(seg, startRange, endRange, delta, low, middle, 2 * pos + 1);
        updateSegmentTreeRange(seg, startRange, endRange, delta, middle + 1, high, 2 * pos + 2);
        seg[pos] = Math.min(seg[2*pos+1], seg[2*pos+2]);
    }

    private int rangeMinimumQuery(int[] seg,int low,int high,int qlow,int qhigh,int pos){
        if(qlow <= low && qhigh >= high){
            return seg[pos];
        }
        if(qlow > high || qhigh < low){
            return Integer.MAX_VALUE;
        }
        int mid = (low+high)/2;
        return Math.min(rangeMinimumQuery(seg, low, mid, qlow, qhigh, 2 * pos + 1),
                rangeMinimumQuery(seg, mid + 1, high, qlow, qhigh, 2 * pos + 2));
    }

    private void updateSegmentTreeRangeLazy(int[] seg,
                                            int[] lazy, int startRange, int endRange,
                                            int delta, int low, int high, int pos) {
        if(low > high) {
            return;
        }

        //make sure all propagation is done at pos. If not update tree
        //at pos and mark its children for lazy propagation.
        if (lazy[pos] != 0) {
            seg[pos] += lazy[pos];
            if (low != high) { //not a leaf node
                lazy[2 * pos + 1] += lazy[pos];
                lazy[2 * pos + 2] += lazy[pos];
            }
            lazy[pos] = 0;
        }

        //no overlap condition
        if(startRange > high || endRange < low) {
            return;
        }

        //total overlap condition
        if(startRange <= low && endRange >= high) {
            seg[pos] += delta;
            if(low != high) {
                lazy[2*pos + 1] += delta;
                lazy[2*pos + 2] += delta;
            }
            return;
        }

        //otherwise partial overlap so look both left and right.
        int mid = (low + high)/2;
        updateSegmentTreeRangeLazy(seg, lazy, startRange, endRange,
                delta, low, mid, 2*pos+1);
        updateSegmentTreeRangeLazy(seg, lazy, startRange, endRange,
                delta, mid+1, high, 2*pos+2);
        seg[pos] = Math.min(seg[2*pos + 1], seg[2*pos + 2]);
    }

    private int rangeMinimumQueryLazy(int[] seg, int[] lazy, int qlow, int qhigh,
                                      int low, int high, int pos) {

        if(low > high) {
            return Integer.MAX_VALUE;
        }

        //make sure all propagation is done at pos. If not update tree
        //at pos and mark its children for lazy propagation.
        if (lazy[pos] != 0) {
            seg[pos] += lazy[pos];
            if (low != high) { //not a leaf node
                lazy[2 * pos + 1] += lazy[pos];
                lazy[2 * pos + 2] += lazy[pos];
            }
            lazy[pos] = 0;
        }

        //no overlap
        if(qlow > high || qhigh < low){
            return Integer.MAX_VALUE;
        }

        //total overlap
        if(qlow <= low && qhigh >= high){
            return seg[pos];
        }

        //partial overlap
        int mid = (low+high)/2;
        return Math.min(rangeMinimumQueryLazy(seg, lazy, qlow, qhigh,
                        low, mid, 2 * pos + 1),
                rangeMinimumQueryLazy(seg, lazy,  qlow, qhigh,
                        mid + 1, high, 2 * pos + 2));

    }

    // https://www.youtube.com/watch?v=xuoQdt5pHj0
    public static void main(String[] args){
        SegmentTreeRangeMinimumQuery st = new SegmentTreeRangeMinimumQuery();

        int[] nums = {0,3,4,2,1,6,-1};
        int[] segTree = st.createSegmentTree(nums);

        //non lazy propagation example
        assert 0 == st.rangeMinimumQuery(segTree, 0, 3, nums.length);
        assert 1 == st.rangeMinimumQuery(segTree, 1, 5, nums.length);
        assert -1 == st.rangeMinimumQuery(segTree, 1, 6, nums.length);
        st.updateSegmentTree(nums, segTree, 2, 1);
        assert 2 == st.rangeMinimumQuery(segTree, 1, 3, nums.length);
        st.updateSegmentTreeRange(nums, segTree, 3, 5, -2);
        assert -1 == st.rangeMinimumQuery(segTree, 5, 6, nums.length);
        assert 0 == st.rangeMinimumQuery(segTree, 0, 3, nums.length);

        //lazy propagation example
        int[] nums1 = {-1,2,4,1,7,1,3,2};
        int[] segTree1 = st.createSegmentTree(nums1);
        int[] lazy1 =  new int[segTree.length];
        st.updateSegmentTreeRangeLazy(nums1, segTree1, lazy1, 0, 3, 1);
        st.updateSegmentTreeRangeLazy(nums1, segTree1, lazy1, 0, 0, 2);
        assert 1 == st.rangeMinimumQueryLazy(segTree1, lazy1, 3, 5, nums1.length);
    }
}
