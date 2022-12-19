package edu.algos.li14_tree;

import edu.algos.li00_model.TreeNode;

public class SubtreeOfAnotherTree {

	public static void main(String[] args) {
		SubtreeOfAnotherTree obj = new SubtreeOfAnotherTree();
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.insert(null, 1, null);
		TreeNode n1 = bt.insert(root, 3, "l");
		TreeNode n2 = bt.insert(root, 4, "r");
		TreeNode n3 = bt.insert(n1, 2, "l");
		TreeNode n4 = bt.insert(n1, 6, "r");
		TreeNode n5 = bt.insert(n4, 5, "l");
		
		System.out.println(obj.isSubtree(root, root));
	}

	// https://leetcode.com/problems/subtree-of-another-tree
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        
        if(root.val == subRoot.val){
            return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }
    
    private boolean isSameTree(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null) {
			return true;
		}else if(root1 == null){
            return false;
        }else if(root2 == null){
            return false;
        }else{
            return (root1.val ==  root2.val) && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
        }
	}
}
