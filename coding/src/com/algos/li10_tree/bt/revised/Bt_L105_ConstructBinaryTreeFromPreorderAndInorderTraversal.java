package  com.algos.li10_tree.bt.revised;

import java.util.HashMap;
import java.util.Map;

import  com.algos.li30_model.TreeNode;


public class Bt_L105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public static void main(String[] args) {
		Bt_L105_ConstructBinaryTreeFromPreorderAndInorderTraversal obj = new Bt_L105_ConstructBinaryTreeFromPreorderAndInorderTraversal();
		
		Bt_L94_BinaryTreeInorderTraversal bt = new Bt_L94_BinaryTreeInorderTraversal();
		TreeNode root = obj.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
		//TreeNode root = obj.buildTree(new int[] {1,2}, new int[] {2,1});
		System.out.println(bt.inorderTraversal(root));
	}
	
    // Problem: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    // Idea: First element on preorder will be root of BT. This divids both inorder and pre order arrays in to 2 halfs.
    // Recursively build left and right subtreesby passing half elements list for each recursive calls.
    // time: O(n)
    // space: O(n)
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inoIndMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++)
            inoIndMap.put(inorder[i], i);

        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inoIndMap);
    }
    
    private TreeNode buildTree(int[] preorder, int pst, int ped, int[] inorder, int is, int ie,
            Map<Integer, Integer> inIndMap) {
        if(pst > ped || is > ie)
            return null;
        
        TreeNode root = new TreeNode(preorder[pst]);
        int inRootInd = inIndMap.get(root.val);
        int numsLeft = inRootInd-is;
        root.left = buildTree(preorder, pst+1, pst+numsLeft, inorder, is, inRootInd-1, inIndMap); // first element in preorder is skipped and mid element in inorder is skipped
        root.right = buildTree(preorder, pst+numsLeft+1, ped, inorder, inRootInd+1, ie, inIndMap);
        return root;
	}
}