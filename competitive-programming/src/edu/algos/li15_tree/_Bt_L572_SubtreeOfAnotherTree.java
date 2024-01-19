package edu.algos.li15_tree;

import edu.algos.li00_model.TreeNode;


public class _Bt_L572_SubtreeOfAnotherTree {

	public static void main(String[] args) {
		_Bt_L572_SubtreeOfAnotherTree obj = new _Bt_L572_SubtreeOfAnotherTree();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
		
		System.out.println(obj.isSubtree(root, root));
	}

	// Problem: https://leetcode.com/problems/subtree-of-another-tree
	// Idea: You have to use isSameTree function. Check in both subtrees if root value are matching.
	// If root values are matching, check if they are same trees from that roots.
	// Even if roots match, same tree might not give true. Hence, need to check in both subtrees.
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;
        
        if(root.val == subRoot.val){
            return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }
    
    private boolean isSameTree(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null) {
			return true;
		}else if(root1 == null || root2 == null){
            return false;
        }else{
            return (root1.val ==  root2.val) && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
        }
	}
}
