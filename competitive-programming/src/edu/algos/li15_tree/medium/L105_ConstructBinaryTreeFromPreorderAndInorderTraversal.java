package edu.algos.li15_tree.medium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import edu.algos.li00_model.TreeNode;


public class L105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public static void main(String[] args) {
		L105_ConstructBinaryTreeFromPreorderAndInorderTraversal obj = new L105_ConstructBinaryTreeFromPreorderAndInorderTraversal();
		
		_A01_BinaryTree bt = new _A01_BinaryTree();
		//TreeNode root = obj.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
		TreeNode root = obj.buildTree(new int[] {1,2}, new int[] {2,1});
		bt.inorder(root);
	}
	
    // Problem: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    // Idea: First element on preorder will be root of BST. This divids both inorder and pre order arrays in to 2 halfs.
    // Recursively build left and right subtreesby passing half elements list for each recursive calls.
    // CHECK
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		List<Integer> preorderList = Arrays.stream(preorder).boxed().collect(Collectors.toList());
		List<Integer> inorderList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        return build(preorderList, inorderList);
    }
    
    private TreeNode build(List<Integer> preorder, List<Integer> inorder) {
        if(preorder.isEmpty() && inorder.isEmpty()){
            return null;
        }
        TreeNode root = new TreeNode(preorder.get(0));
        int mid = inorder.indexOf(preorder.get(0));
        root.left = build(preorder.subList(1, mid+1), inorder.subList(0, mid)); // first element in preorder is skipped and mid element in inorder is skipped
        root.right = build(preorder.subList(mid+1, preorder.size()), inorder.subList(mid+1, inorder.size()));
        return root;
	}
}