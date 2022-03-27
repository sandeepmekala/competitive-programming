package edu.ds.trees.model;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public int data;
	
	public TreeNode(int data){
		this.left = null;
		this.right = null;
		this.data = data;
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

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "[" + data + "]";
	}
	

}
