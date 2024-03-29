package edu.algos.li15_tree;

import edu.algos.li00_model.TreeNode;


public class _Bt_L236_LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        _Bt_L236_LowestCommonAncestorOfABinaryTree obj = new _Bt_L236_LowestCommonAncestorOfABinaryTree();

        TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);

        System.err.println(obj.lowestCommonAncestor(root, root.left.left, root.left.right.left));
    } 
 
    // Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    // Idea: Find num1 and num2. If found return its root else return null.  
    // At LCA root, you will recieve not null responses from it left and right. Return that root as LCA. 
    // time: O(n)
    // space: O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val) 
			return root;
		
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if(left == null) {
			return right;
		}else if(right == null){
			return left;
		}else {
			return root;
		}
    }
}
