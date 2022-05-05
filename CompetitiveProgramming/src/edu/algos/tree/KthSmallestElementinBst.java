package edu.algos.tree;

import java.util.Stack;

import edu.algos.model.TreeNode;

public class KthSmallestElementinBst {

	public static void main(String[] args) {
		KthSmallestElementinBst obj = new KthSmallestElementinBst();
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = bst.insert(null, 10);
		bst.insert(root, 2);
		bst.insert(root, 4);
		bst.insert(root, 6);
		bst.insert(root, 5);
		bst.insert(root, 15);
		bst.insert(root, 3);
		
		System.out.println(obj.kthSmallest(root, 3));

	}

	public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        int count = 0;
        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
                
            }
            current = stack.pop();
            count++;
            if(count == k){
                return current.val;
            }
            current = current.right;
        }
        return count;
    }
}
