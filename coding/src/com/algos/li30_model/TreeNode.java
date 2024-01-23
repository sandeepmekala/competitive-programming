package edu.algos.li30_model;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public int val;
	
	public TreeNode(int val){
		this.left = null;
		this.right = null;
		this.val = val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "[" + val + "]";
	}
	

}
