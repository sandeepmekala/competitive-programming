package edu.algos.tree;

import edu.algos.model.TreeNode;

public class InvertBinaryTree {

	public static void main(String[] args) {
		InvertBinaryTree obj = new InvertBinaryTree();
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.insert(null, 1, null);
		TreeNode n1 = bt.insert(root, 3, "l");
		TreeNode n2 = bt.insert(root, 4, "r");
		TreeNode n3 = bt.insert(n1, 2, "l");
		TreeNode n4 = bt.insert(n1, 6, "r");
		TreeNode n5 = bt.insert(n4, 5, "l");
		
		bt.inorder(root);
		obj.invertTree(root);
		System.out.println();
		bt.inorder(root);
	}
	
	private TreeNode invertTree(TreeNode root) {
        if(root !=  null){
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;
        }
        return root;
    }

}
