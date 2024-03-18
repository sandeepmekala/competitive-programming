package  com.algos.li10_tree.bst.revised;

import  com.algos.li30_model.TreeNode;


public class L333_LargestBstSubtree {
    
	public static void main(String[] args) {
		L333_LargestBstSubtree obj = new L333_LargestBstSubtree();
		
        TreeNode root = new TreeNode(6);
		root.left = new TreeNode(3);
		root.right = new TreeNode(5);
        root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
        root.left.right.right = new TreeNode(1);
		
        System.out.println(obj.maxSumBST(root));
    }
	
    // Problem: https://leetcode.com/problems/largest-bst-subtree/
	// https://www.lintcode.com/problem/910/
    // Idea: Use a data structure int[]{size, min, max}
	// time: O(n)
    // space: O(1)
	private int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;
	public int maxSumBST(TreeNode root) {
		return maxSizeBstRec(root).size;
	}

	private NodeState maxSizeBstRec(TreeNode root) {
		if(root == null)	// a empty tree is bst of size 0
			return new NodeState(0, MAX, MIN);
		
		NodeState left = maxSizeBstRec(root.left);
		NodeState right = maxSizeBstRec(root.right);
		
		if(root.val > left.max && root.val < right.min){
			return new NodeState(left.size+right.size+1, 
				Math.min(left.min, root.val), Math.max(right.max, root.val)); // Math.min to avoid null node max value. Otherwise, it will be left.min
		}else{
			return new NodeState(Math.max(left.size, right.size), 
				MIN, MAX);
		}
	}
}
class NodeState{
	public int size, min, max;
	public NodeState(int size, int min, int max) {
		this.size = size;
		this.min = min;
		this.max = max;
	}
}