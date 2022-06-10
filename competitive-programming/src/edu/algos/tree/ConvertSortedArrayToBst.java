package edu.algos.tree;

import edu.algos.model.TreeNode;

public class ConvertSortedArrayToBst {

	public static void main(String[] args) {
		ConvertSortedArrayToBst obj = new ConvertSortedArrayToBst();
		int[] nums = new int[] {-10,-3,0,5,9};
		TreeNode root = obj.sortedArrayToBST(nums);
		System.out.println(root);
	}

	public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
    
    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if(start <= end){
            int mid = (start+end)/2;
            TreeNode root = new TreeNode(nums[mid]);
            TreeNode left = sortedArrayToBST(nums, start, mid-1);
            TreeNode right = sortedArrayToBST(nums, mid+1, end);
            root.left = left;
            root.right = right;
            
            return root;
        }
        return null;

    }
}
