package edu.algos.li15_tree.easy;

import edu.algos.li00_model.TreeNode;


public class L543_DiameterOfBinaryTree {

	public static void main(String[] args) {
		L543_DiameterOfBinaryTree obj = new L543_DiameterOfBinaryTree();
				
        TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
		
		System.out.println(obj.diameterOfBinaryTree(root));
	}

    // Problem: https://leetcode.com/problems/diameter-of-binary-tree/
    // Idea: At each node we have to return max len of if left and right paths. 
    // And also, max diameter can be found anywhere in the tree. This also need to be bubbled up. 
    // If we bubble this max, it gets complex as we need to max of curr root, max came from left and right. 
    // To simplify this we use global max variable.
	private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        this.diameterRec(root);
        return max;
    }

    private int diameterRec(TreeNode root) {
        int left = 0;
        if(root.left != null){
            left = 1+diameterRec(root.left); 
        }
        
        int right = 0;
        if(root.right != null){
            right = 1+diameterRec(root.right); 
        }
        
        max = Math.max(max, left+right);
        return Math.max(left, right);
    }
}
