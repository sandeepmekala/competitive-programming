package edu.algos.li15_tree.medium;

import edu.algos.li00_model.TreeNode;


public class L236_LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        L236_LowestCommonAncestorOfABinaryTree obj = new L236_LowestCommonAncestorOfABinaryTree();

        		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);

        System.err.println(obj.lowestCommonAncestor(root, n2, n3));
    }

    // Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    // Idea: Find num1 and num2. If found return its root else return null.
    // At LCA root, you will recieve not null responses from it left and right. Return that root as LCA. 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
			return null;
		}
		if(root.val == p.val || root.val == q.val) {
			return root;
		}
		
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if(left != null && right !=  null) {
			return root;
		}else if(left != null) {
			return left;
		}else if(right != null){
			return right;
		}else {
			return null;
		}
    }
}
