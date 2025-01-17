package  com.algos.core.li10_tree.bt;

import com.algos.core.li10_tree.bst.revised.L701_InsertIntoABinarySearchTree;
import  com.algos.core.li30_model.TreeNode;

public class Bt_L617_MergeTwoBinaryTrees {

	public static void main(String[] args) {
		Bt_L617_MergeTwoBinaryTrees obj = new Bt_L617_MergeTwoBinaryTrees();
		
		L701_InsertIntoABinarySearchTree bst1 = new L701_InsertIntoABinarySearchTree();
		TreeNode root1 = bst1.insertIntoBST(null, 10);
		bst1.insertIntoBST(root1, 2);
		bst1.insertIntoBST(root1, 4);
		bst1.insertIntoBST(root1, 6);
		bst1.insertIntoBST(root1, 5);
		bst1.insertIntoBST(root1, 15);
		bst1.insertIntoBST(root1, 3);
		
		L701_InsertIntoABinarySearchTree bst2 = new L701_InsertIntoABinarySearchTree();
		TreeNode root2 = bst2.insertIntoBST(null, 10);
		bst2.insertIntoBST(root2, 2);
		bst2.insertIntoBST(root2, 4);
		bst2.insertIntoBST(root2, 6);
		bst2.insertIntoBST(root2, 5);
		bst2.insertIntoBST(root2, 15);
		bst2.insertIntoBST(root2, 3);
		
		obj.mergeTrees(root1, root2);
		//bst1.inorder(root1);
	}

	/*
	 * Problem: https://leetcode.com/problems/merge-two-binary-trees/
	 * Idea: Traverse both the lists at the same time.
	 * */
	// Time: O(n)
    // space: O(1)
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) 
			return null;
        else if(root1 == null) 
			return root2;
        else if(root2 == null) 
			return root1;
        else{
            root1.val = root1.val+root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
    }
}
