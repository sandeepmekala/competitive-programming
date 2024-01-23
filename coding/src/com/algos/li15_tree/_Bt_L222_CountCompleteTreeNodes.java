package  com.algos.li15_tree;

import  com.algos.li30_model.TreeNode;

public class _Bt_L222_CountCompleteTreeNodes {
    public static void main(String[] args) {
        _Bt_L222_CountCompleteTreeNodes obj = new _Bt_L222_CountCompleteTreeNodes();

        TreeNode root = new TreeNode(1);
		// root.left = new TreeNode(2);
		// root.right = new TreeNode(3);
		// root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        // root.right.left = new TreeNode(6);

        System.out.println(obj.countNodes(root));
    }

    // Problem: https://leetcode.com/problems/count-complete-tree-nodes/
    // Idea: If you are standing at a root, if the left and right subtrees have same height, then no of nodes 2^h-1.
    // Else we have to recursively count in left and right subtrees + 1
    // time: O(logn)
    // space: O(1)
    public int countNodes(TreeNode root) {
        if(root == null) 
            return 0;

        int lHeight = getLeftHeight(root);
        int rHeight = getRightHeight(root);

        if(lHeight == rHeight)
            return (int)Math.pow(2, lHeight) - 1;
        else    
            return 1+countNodes(root.left)+countNodes(root.right);
    }

    private int getLeftHeight(TreeNode root){
        int count = 0;
        TreeNode node = root;
        while(node != null){
            count++;
            node = node.left;
        }
        return count;
    }

    private int getRightHeight(TreeNode root){
        int count = 0;
        TreeNode node = root;
        while(node != null){
            count++;
            node = node.right;
        }
        return count;
    }
}
