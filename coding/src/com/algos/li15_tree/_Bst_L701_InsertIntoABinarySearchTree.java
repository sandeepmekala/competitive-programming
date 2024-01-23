 package  com.algos.li15_tree;

import  com.algos.li30_model.TreeNode;

public class _Bst_L701_InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        _Bst_L701_InsertIntoABinarySearchTree obj = new _Bst_L701_InsertIntoABinarySearchTree();

		TreeNode root = obj.insertIntoBST(null, 10);
		obj.insertIntoBST(root, 2);
		obj.insertIntoBST(root, 4);
		obj.insertIntoBST(root, 6);
		obj.insertIntoBST(root, 5);
		obj.insertIntoBST(root, 15);
		obj.insertIntoBST(root, 3);

        System.out.println(root);
    }

    // Problem: https://leetcode.com/problems/insert-into-a-binary-search-tree/ 
	// Idea: If val < root, insert in left subtree else insert in right subtree.
    // time: O(logn)
    // space: O(1)
	public TreeNode insertIntoBST(TreeNode  root, int val){
		if(root == null)
			return new TreeNode(val);

		if(val < root.val){
			root.left = insertIntoBST(root.left, val);
		}else{
			root.right = insertIntoBST(root.right, val);
		}

		return root;
	}

	public TreeNode insertIntoBSTIterative(TreeNode  root, int val){
		if(root == null) 
			return new TreeNode(val);

		TreeNode curr = root;
		while(true){
			if(val > curr.val){
				if(curr.right != null){
					curr = curr.right;
				}else{
					curr.right = new TreeNode(val);
					break;
				}
			}else{
				if(curr.left != null){
					curr = curr.left;
				}else{
					curr.left = new TreeNode(val);
					break;
				}
			}
		}
		return root;
	}	
}
