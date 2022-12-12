package edu.algos.li14.tree;

import java.util.ArrayList;

import edu.algos.li00_model.TreeNode;

public class ConstructStringFromBinaryTree {

	public static void main(String[] args) {
		ConstructStringFromBinaryTree obj = new ConstructStringFromBinaryTree();
		
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.insert(null, 1, null);
		TreeNode n1 = bt.insert(root, 3, "l");
		TreeNode n2 = bt.insert(root, 4, "r");
		TreeNode n3 = bt.insert(n1, 2, "l");
		TreeNode n4 = bt.insert(n1, 6, "r");
		TreeNode n5 = bt.insert(n4, 5, "l");
		
		System.out.println(obj.tree2str(root));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/construct-string-from-binary-tree/
	 * */
	public String tree2str(TreeNode root) {
        return tree2str(root, false);
    }
    
    private String tree2str(TreeNode root, boolean isLeft){
        if(root == null && isLeft) return ""; 
        if(root == null && !isLeft) return null;
        if(root.left == null && root.right == null) return String.valueOf(root.val);
        
        StringBuffer sb = new StringBuffer();
        sb.append(String.valueOf(root.val));

        String left = tree2str(root.left, true);
        String right = tree2str(root.right, false);
        sb.append("(");
        sb.append(left);
        sb.append(")");    
        if(right != null){
            sb.append("(");
            sb.append(right);
            sb.append(")");            
        }
        
        return sb.toString();
    }
}
