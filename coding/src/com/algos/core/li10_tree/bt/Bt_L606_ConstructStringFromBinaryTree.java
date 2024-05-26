package  com.algos.core.li10_tree.bt;

import  com.algos.core.li30_model.TreeNode;


public class Bt_L606_ConstructStringFromBinaryTree {

	public static void main(String[] args) {
		Bt_L606_ConstructStringFromBinaryTree obj = new Bt_L606_ConstructStringFromBinaryTree();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
		
		System.out.println(obj.tree2str(root));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/construct-string-from-binary-tree/
     * Idea: If left child is not there and right child is there, we need to keep () for left child. But not need to keep if right child is not there.
     * Hence, we need to pass flag to dinote if it left child recursive call or right child call.
	 * TODO
     * */
	public String tree2str(TreeNode root) {
        return tree2str(root, false);
    }
    
    private String tree2str(TreeNode root, boolean isLeft){
        if(root == null && isLeft) 
            return ""; 
        if(root == null && !isLeft) 
            return null;
        if(root.left == null && root.right == null) 
            return String.valueOf(root.val);
        
            
        String left = tree2str(root.left, true);
        String right = tree2str(root.right, false);

        StringBuffer sb = new StringBuffer(String.valueOf(root.val));

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
