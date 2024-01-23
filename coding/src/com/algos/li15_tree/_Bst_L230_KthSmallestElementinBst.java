package  com.algos.li15_tree;

import java.util.Stack;

import  com.algos.li30_model.TreeNode;

public class _Bst_L230_KthSmallestElementinBst {

	public static void main(String[] args) {
		_Bst_L230_KthSmallestElementinBst obj = new _Bst_L230_KthSmallestElementinBst();
		_Bst_L701_InsertIntoABinarySearchTree bst = new _Bst_L701_InsertIntoABinarySearchTree();
		TreeNode root = bst.insertIntoBST(null, 10);
		bst.insertIntoBST(root, 2);
		bst.insertIntoBST(root, 4);
		bst.insertIntoBST(root, 6);
		bst.insertIntoBST(root, 5);
		bst.insertIntoBST(root, 15);
		bst.insertIntoBST(root, 3);
		
		System.out.println(obj.kthSmallest(root, 3));

	}

    // Problem: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    // Idea: Traverse the BST using iterative inorder and return when count == k.
    // You can use morris traversal to reduce the space.
    // time: O(logn)
    // space: O(logn)
	public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        int count = 0;
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            } else{
                curr = stack.pop();
                count++;
                if(count == k)
                    return curr.val;
                
                curr = curr.right;
            }
        }

        return -1;
    }
}
