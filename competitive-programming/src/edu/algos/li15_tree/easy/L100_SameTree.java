package edu.algos.li15_tree.easy;

import edu.algos.li00_model.TreeNode;

public class L100_SameTree {
 
    public static void main(String[] args) {
        L100_SameTree obj = new L100_SameTree();

        TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
        
        System.out.println(obj.isSameTree(root, root));
    }

    // Problem: https://leetcode.com/problems/same-tree/
    // Idea: Root values should be same and left and right sub trees should be same trees.
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
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
