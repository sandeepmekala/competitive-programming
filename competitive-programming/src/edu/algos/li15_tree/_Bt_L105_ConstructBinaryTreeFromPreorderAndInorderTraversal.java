package edu.algos.li15_tree;

import java.util.HashMap;
import java.util.Map;

import edu.algos.li00_model.TreeNode;


public class _Bt_L105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public static void main(String[] args) {
		_Bt_L105_ConstructBinaryTreeFromPreorderAndInorderTraversal obj = new _Bt_L105_ConstructBinaryTreeFromPreorderAndInorderTraversal();
		
		_Bt_L94_BinaryTreeInorderTraversal bt = new _Bt_L94_BinaryTreeInorderTraversal();
		TreeNode root = obj.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
		//TreeNode root = obj.buildTree(new int[] {1,2}, new int[] {2,1});
		System.out.println(bt.inorderTraversal(root));
	}
	
    // Problem: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    // Idea: First element on preorder will be root of BST. This divids both inorder and pre order arrays in to 2 halfs.
    // Recursively build left and right subtreesby passing half elements list for each recursive calls.
    // TODO
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inIndMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inIndMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inIndMap);
    }
    
    private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie,
            Map<Integer, Integer> inIndMap) {
        if(ps > pe || is > ie)
            return null;
        
        TreeNode root = new TreeNode(preorder[ps]);
        int inRootInd = inIndMap.get(root.val);
        int numsLeft = inRootInd-is;
        root.left = buildTree(preorder, ps+1, ps+numsLeft, inorder, is, inRootInd-1, inIndMap); // first element in preorder is skipped and mid element in inorder is skipped
        root.right = buildTree(preorder, ps+numsLeft+1, pe, inorder, inRootInd+1, ie, inIndMap);
        return root;
	}
}