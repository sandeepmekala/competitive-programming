package edu.algos.li15_tree.medium;

import java.util.HashMap;
import java.util.Map;

import edu.algos.li00_model.TreeNode;
import edu.algos.li15_tree.easy.Bt_L94_BinaryTreeInorderTraversal;


public class Bt_L105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public static void main(String[] args) {
		Bt_L105_ConstructBinaryTreeFromPreorderAndInorderTraversal obj = new Bt_L105_ConstructBinaryTreeFromPreorderAndInorderTraversal();
		
		Bt_L94_BinaryTreeInorderTraversal bt = new Bt_L94_BinaryTreeInorderTraversal();
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
    
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> inIndMap) {
        if(preStart > preEnd || inStart > inEnd)
            return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int InRootInd = inIndMap.get(root.val);
        int numsLeft = InRootInd-inStart;
        root.left = buildTree(preorder, preStart+1, preStart+numsLeft, inorder, inStart, InRootInd-1, inIndMap); // first element in preorder is skipped and mid element in inorder is skipped
        root.right = buildTree(preorder, preStart+numsLeft+1, preEnd, inorder, InRootInd+1, inEnd, inIndMap);
        return root;
	}
}