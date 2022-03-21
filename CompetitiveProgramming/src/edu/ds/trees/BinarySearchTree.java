package edu.ds.trees;

import java.util.ArrayList;
import java.util.Arrays;

import edu.ds.trees.model.Node;

public class BinarySearchTree {

	public static Node root;
	
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
		System.out.println(bst.search(root, 10).data);
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
		
		System.out.println(isBinary(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		System.out.println("lca :"+bst.lca(root, 2, 5));
	}
	
	private Node insert(Node  root, int data){
		if(root == null){
			root  = new Node(data);
		}else{
			if(data < root.data){
				root.setLeft(insert(root.left, data));
			}else if(data > root.data){
				root.setRight(insert(root.right, data));
			}
		}
		
		return root;
	}
	private Node search(Node  root, int data){
		
		if(root == null || root.data == data){
			return root;
		}
		
		if(data < root.data){
			return search(root.left, data);
		}else{
			return search(root.right, data);
		}
	}
	private Node delete(Node root, int data){
		if(root == null){
			return null;
		}else{
			if(data < root.data){
				root.setLeft(delete(root.left, data));
			}else if(data > root.data){
				root.setRight(delete(root.right, data));
			}else{
				if(root.left == null && root.right == null){
					return null;
				}else if(root.left == null){
					return root.right;
				}else if(root.right == null){
					return root.left;
				}else {
					Node succParent = root;
					Node succ = root.right;

					while(succ.left != null){
						succParent = succ;
						succ = succ.left;
					}
					if(succParent != root) {
						succParent.setLeft(succ.right);
					}else {
						root.setRight(succ.right);
					}
					root.setData(succ.data);
					return root;
				}
			}
		}
		return root;
	}
	private int size(Node root){
		if(root == null){
			return 0;
		}
		return 1+size(root.left)+size(root.right);
	}
	
	private void preorder(Node root){
		if(root != null){	
			System.out.print(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	private void postorder(Node root){
		if(root != null){	
			preorder(root.left);
			preorder(root.right);
			System.out.print(root.data+" ");
		}
	}
	private void inorder(Node root){
		if(root != null){	
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	
	public boolean path(Node root, int data, ArrayList<Integer> path){
		if(root == null){
			return false;
		}
		if(data == root.data){
			path.add(root.data);
			return true;
		}else if(data < root.data) {
			if(path(root.left, data, path)) {
				path.add(root.data);
				return true;
			}
		}else {
			if(path(root.right, data, path)) {
				path.add(root.data);
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isBinary(Node root, int min, int max) {
		if(root == null) {
			return true;
		}
		if(root.data > min && root.data < max) {
			return true;
		}
		return isBinary(root.left, min, root.data) && isBinary(root.right, root.data, max); 
	}
	
	private int lca(Node root, int num1, int num2){

		if(num1 < root.data && num2 < root.data){
			return lca(root.left, num1, num2);
		}else if(num1 > root.data && num2 > root.data){
			return lca(root.right, num1, num2);
		}else{
			return root.data;
		}		
	}
}
