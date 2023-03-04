package edu.algos.li15_tree;

import java.util.ArrayList;
import java.util.List;

import edu.algos.li00_model.TreeNode;

public class Bt_PrintRootToNodePathInBinaryTree {

	public static void main(String[] args) {
		Bt_PrintRootToNodePathInBinaryTree obj = new Bt_PrintRootToNodePathInBinaryTree();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
		
		System.out.println(obj.path(root, 5));
	}
	
	// Problem: https://www.interviewbit.com/problems/path-to-given-node/
	public List<Integer> path(TreeNode root, int data){
		ArrayList<Integer> list = new ArrayList<>();
		if(!path(root, 5, list)) return null;
		return list;
	}
	private boolean path(TreeNode root, int data, ArrayList<Integer> path){
		if(root == null)
			return false;
		
		path.add(root.val);
		if(data == root.getVal())
			return true;
		
		if(path(root.left, data, path) || path(root.right, data, path)) 
			return true;
		
		path.remove(path.size()-1);
		return false;
	}

}
