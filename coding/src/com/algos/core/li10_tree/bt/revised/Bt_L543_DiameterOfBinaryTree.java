package  com.algos.core.li10_tree.bt.revised;

import  com.algos.core.li30_model.TreeNode;


public class Bt_L543_DiameterOfBinaryTree {

	public static void main(String[] args) {
		Bt_L543_DiameterOfBinaryTree obj = new Bt_L543_DiameterOfBinaryTree();
				
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
    // Time: O(n)
    // space: O(1)
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    //height
    private int height(TreeNode root, int[] diameter) {
		if(root == null) 
			return 0;
		
		int lHeight = height(root.left, diameter);
		int rHeight = height(root.right, diameter);
		
		diameter[0] = Math.max(diameter[0], lHeight+rHeight);

		return 1 + Math.max(lHeight, rHeight);
    }
}
