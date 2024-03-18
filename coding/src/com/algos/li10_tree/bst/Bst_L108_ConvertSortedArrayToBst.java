package  com.algos.li10_tree.bst;

import  com.algos.li30_model.TreeNode;

public class Bst_L108_ConvertSortedArrayToBst {

	public static void main(String[] args) {
		Bst_L108_ConvertSortedArrayToBst obj = new Bst_L108_ConvertSortedArrayToBst();
		int[] nums = new int[] {-10,-3,0,5,9};
		TreeNode root = obj.sortedArrayToBST(nums);
		System.out.println(root);
	}

    // Problem: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
    // Idea: We have to build BST in recursive way bottom up.
    // Use binary search kind approach to recursively divide the array into 2 halfs and build BST for each half as left and right subtrees. mid will be the root.
	public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
    
    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if(start > end)
            return null;
        
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = sortedArrayToBST(nums, start, mid-1);
        TreeNode right = sortedArrayToBST(nums, mid+1, end);
        root.left = left;
        root.right = right;
        
        return root;
    }
}
