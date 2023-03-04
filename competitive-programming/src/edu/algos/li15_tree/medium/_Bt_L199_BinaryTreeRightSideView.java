package edu.algos.li15_tree.medium;

import java.util.ArrayList;
import java.util.List;

import edu.algos.li00_model.TreeNode;


public class _Bt_L199_BinaryTreeRightSideView {

	public static void main(String[] args) {
		_Bt_L199_BinaryTreeRightSideView obj = new _Bt_L199_BinaryTreeRightSideView();
		
        TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
		
		System.out.println(obj.rightSideView(root));
	}

    // Problem: https://leetcode.com/problems/binary-tree-right-side-view/
    // Idea: Apply inorder with right first. Pass level as arg to function. 
    // At each level if size of result is equal to level add that element. Once an element already added at right side, there won't be any element gets added left side as result list size would have increased.
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorder(root, 0, result);
        return result;
    }
    
    private void preorder(TreeNode root, int level, List<Integer> result){
        if(root == null) return;
        
        if(result.size() == level)
            result.add(root.val);
        
        preorder(root.right, level+1, result);
        preorder(root.left, level+1, result);
    }
}
