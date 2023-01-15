package edu.algos.li15_tree.medium;

import java.util.HashMap;
import java.util.Map;

import edu.algos.li00_model.TreeNode;
import edu.algos.li15_tree.easy.Bt_L94_BinaryTreeInorderTraversal;


public class Bt_L106_ConstructBinaryTreeFromPostorderAndInorderTraversal {

	public static void main(String[] args) {
		Bt_L106_ConstructBinaryTreeFromPostorderAndInorderTraversal obj = new Bt_L106_ConstructBinaryTreeFromPostorderAndInorderTraversal();
		
		Bt_L94_BinaryTreeInorderTraversal bt = new Bt_L94_BinaryTreeInorderTraversal();
		TreeNode root = obj.buildTree(new int[] {9,3,15,20,7}, new int[] {9,15,7,20,3});
		System.out.println(bt.inorderTraversal(root));
	}
	
    // Problem: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    // Idea: Lst element on postorder will be root of BST. This divids both inorder and pre order arrays in to 2 halfs.
    // Recursively build left and right subtreesby passing half elements list for each recursive calls.
    // TODO
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inIndMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inIndMap.put(inorder[i], i);
        }

        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inIndMap);
    }
    
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,
            Map<Integer, Integer> inIndMap) {
        if(postStart > postEnd || inStart > inEnd)
            return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int InRootInd = inIndMap.get(root.val);
        int numsLeft = InRootInd-inStart;
        root.left = buildTree(inorder, inStart, InRootInd-1, postorder, postStart, postStart+numsLeft-1, inIndMap); // first element in preorder is skipped and mid element in inorder is skipped
        root.right = buildTree(inorder, InRootInd+1, inEnd, postorder, postStart+numsLeft, postEnd-1, inIndMap);
        return root;
	}
}