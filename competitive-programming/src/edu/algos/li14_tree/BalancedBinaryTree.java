package edu.algos.li14_tree;

import edu.algos.li00_model.TreeNode;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		BalancedBinaryTree obj = new BalancedBinaryTree();
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.insert(null, 1, null);
		TreeNode n1 = bt.insert(root, 3, "l");
		TreeNode n2 = bt.insert(root, 4, "r");
		TreeNode n3 = bt.insert(n1, 2, "l");
		TreeNode n4 = bt.insert(n1, 6, "r");
		
		System.out.println(obj.isBalanced(root));
	}
	
	public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int diff = Math.abs(leftHeight - rightHeight);
        
        return (diff <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int height(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		return 1 + Math.max(height(root.left), height(root.right));
	}

}
