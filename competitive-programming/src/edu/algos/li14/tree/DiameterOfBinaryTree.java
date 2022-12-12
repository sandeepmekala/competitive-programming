package edu.algos.li14.tree;

import edu.algos.li00_model.TreeNode;

public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.insert(null, 1, null);
		TreeNode n1 = bt.insert(root, 3, "l");
		TreeNode n2 = bt.insert(root, 4, "r");
		TreeNode n3 = bt.insert(n1, 2, "l");
		TreeNode n4 = bt.insert(n1, 6, "r");
		TreeNode n5 = bt.insert(n4, 5, "l");
		
		System.out.println(obj.diameterOfBinaryTree(root));
	}

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
