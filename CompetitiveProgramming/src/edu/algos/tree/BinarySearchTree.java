package edu.algos.tree;

import java.util.ArrayList;
import java.util.Arrays;

import edu.algos.model.TreeNode;

public class BinarySearchTree {

	public static TreeNode root;
	
	public static void main(String[] args) {	
		
		//			10
		//		  /	   \		
		//		2		15
		//	  	  \
		//			4
		//		  /	  \
		//		3		6
		//			  /
		//			5
		BinarySearchTree bst = new BinarySearchTree();
		root = bst.insert(null, 10);
		bst.insert(root, 2);
		bst.insert(root, 4);
		bst.insert(root, 6);
		bst.insert(root, 5);
		bst.insert(root, 15);
		bst.insert(root, 3);
		
		bst.inorder(root);
		System.out.println("delete: "+4);
		bst.delete(root, 4);
		bst.inorder(root);
		System.out.println();
		
		System.out.println("search 30:");
		System.out.println(bst.search(root, 10).val);
		System.out.println();
		System.out.println("inorder:");
		bst.inorder(root);
		System.out.println();
		System.out.println("preorder:");
		bst.preorder(root);
		System.out.println();
		System.out.println("postorder:");
		bst.postorder(root);
		
		System.out.println("\nsize:");
		System.out.println(bst.size(root));
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		System.out.println(bst.path(root, 5, path));
		System.out.println("path"+path);
		
		System.out.println(isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		System.out.println("lca :"+bst.lca(root, 2, 5));
	}
	
	public TreeNode insert(TreeNode  root, int data){
		if(root == null){
			root  = new TreeNode(data);
		}else{
			if(data < root.val){
				root.setLeft(insert(root.left, data));
			}else if(data > root.val){
				root.setRight(insert(root.right, data));
			}
		}
		
		return root;
	}
	private TreeNode search(TreeNode  root, int data){
		
		if(root == null || root.val == data){
			return root;
		}
		
		if(data < root.val){
			return search(root.left, data);
		}else{
			return search(root.right, data);
		}
	}
	private TreeNode delete(TreeNode root, int data){
		if(root == null){
			return null;
		}else{
			if(data < root.val){
				root.setLeft(delete(root.left, data));
			}else if(data > root.val){
				root.setRight(delete(root.right, data));
			}else{
				if(root.left == null && root.right == null){
					return null;
				}else if(root.left == null){
					return root.right;
				}else if(root.right == null){
					return root.left;
				}else {
					TreeNode succParent = root;
					TreeNode succ = root.right;

					while(succ.left != null){
						succParent = succ;
						succ = succ.left;
					}
					if(succParent != root) {
						succParent.setLeft(succ.right);
					}else {
						root.setRight(succ.right);
					}
					root.setData(succ.val);
					return root;
				}
			}
		}
		return root;
	}
	private int size(TreeNode root){
		if(root == null){
			return 0;
		}
		return 1+size(root.left)+size(root.right);
	}
	
	public void preorder(TreeNode root){
		if(root != null){	
			System.out.print(root.val+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void postorder(TreeNode root){
		if(root != null){	
			preorder(root.left);
			preorder(root.right);
			System.out.print(root.val+" ");
		}
	}
	
	public void inorder(TreeNode root){
		if(root != null){	
			inorder(root.left);
			System.out.print(root.val+" ");
			inorder(root.right);
		}
	}
	
	public boolean path(TreeNode root, int data, ArrayList<Integer> path){
		if(root == null){
			return false;
		}
		if(data == root.val){
			path.add(root.val);
			return true;
		}else if(data < root.val) {
			if(path(root.left, data, path)) {
				path.add(root.val);
				return true;
			}
		}else {
			if(path(root.right, data, path)) {
				path.add(root.val);
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isBst(TreeNode root, int min, int max) {
		if(root == null) {
			return true;
		}
		return (root.val > min && root.val < max) && 
				isBst(root.left, min, root.val) && isBst(root.right, root.val, max); 
	}
	
	private int lca(TreeNode root, int num1, int num2){

		if(num1 < root.val && num2 < root.val){
			return lca(root.left, num1, num2);
		}else if(num1 > root.val && num2 > root.val){
			return lca(root.right, num1, num2);
		}else{
			return root.val;
		}		
	}
}
