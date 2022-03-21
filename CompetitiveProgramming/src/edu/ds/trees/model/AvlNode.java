package edu.ds.trees.model;

public class AvlNode{

	public AvlNode left;
	public AvlNode right;
	public int data;
	public int height = 0;
	
	public AvlNode(int data, int height){
		this.left = null;
		this.right = null;
		this.data = data;
		this.height = height;
	}
	@Override
	public String toString() {
		return "[" + data + "("+height+")]";
	}
}
