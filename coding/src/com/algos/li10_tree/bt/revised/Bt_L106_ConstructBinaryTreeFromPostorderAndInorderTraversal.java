package  com.algos.li10_tree.bt.revised;

import java.util.HashMap;
import java.util.Map;

import  com.algos.li30_model.TreeNode;


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
    // time: O(n)
    // space: O(n)
    // TODO
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inIndMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++)
            inIndMap.put(inorder[i], i);

        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inIndMap);
    }
    
    private TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
            Map<Integer, Integer> inIndMap) {
        if(ps > pe || is > ie)
            return null;
        
        TreeNode root = new TreeNode(postorder[pe]);
        int inRootInd = inIndMap.get(root.val);
        int numsLeft = inRootInd-is;
        root.left = buildTree(inorder, is, inRootInd-1, postorder, ps, ps+numsLeft-1, inIndMap); // first element in preorder is skipped and mid element in inorder is skipped
        root.right = buildTree(inorder, inRootInd+1, ie, postorder, ps+numsLeft, pe-1, inIndMap);
        return root;
	}
}