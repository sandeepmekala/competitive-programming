package edu.algos.li15_tree.medium;

import javax.jws.Oneway;

import edu.algos.li00_model.TreeNode;


public class L333_LargestBstSubtree {
    
    public static void main(String[] args) {
        L333_LargestBstSubtree obj = new L333_LargestBstSubtree();

        TreeNode root = new TreeNode(6);
		root.left = new TreeNode(3);
		root.right = new TreeNode(5);
        root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
        root.left.right.right = new TreeNode(1);

        System.out.println(obj.maxSizeBst(root));
    }

    // Problem: https://leetcode.com/problems/largest-bst-subtree/
	// https://www.lintcode.com/problem/1106/
    // Idea: Use a data structure int[]{size, min, max } 
	public int maxSizeBst(TreeNode root) {
		return maxSizeBstRec(root).maxSize;
	}
	public NodeState maxSizeBstRec(TreeNode root) {
		if(root == null) {	// a empty tree is bst of size 0
			return new NodeState(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		
		NodeState left = maxSizeBstRec(root.left);
		NodeState right = maxSizeBstRec(root.right);
		
		if(root.val > left.maxNode && root.val < right.minNode){
			return new NodeState(left.maxSize+right.maxSize+1, 
				Math.min(left.minNode, root.val), Math.max(right.maxNode, root.val));
		}else{
			return new NodeState(Math.max(left.maxSize, right.maxSize), 
				Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
	}
}
class NodeState{
	public int maxSize, minNode, maxNode;
	public NodeState(int size, int min, int max) {
		this.maxSize = size;
		this.minNode = min;
		this.maxNode = max;
	}
}