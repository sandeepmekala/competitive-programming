package edu.algos.li14.tree;

import edu.algos.li00.model.AvlNode;

public class AvlTree {

	private static AvlNode root;
	public static void main(String[] args) {
		// l-l rotation
		//				10						10		
		//			  /	  \					  /	   \
		//			5		20				-10		20
		//		  /					->		/  \
		//		-10						  -20	5
		//	 	/
		//	  -20
		
		// l-r rotation
		//				10						10						10
		//			  /	  \					  /	   \				  /	   \
		//			5		20				 5		20				-5		20
		//		  /					->		/  				->	   /   \	
		//		-10						  -5					 -10	5
		//	 	   \					  /
		//	  		-5					-10
		
		// r-l rotation
		//				10						10						10
		//			  /	  \					  /	   \				  /	   \
		//			5		20				 5		20				 6		20
		//		  	  \				->		  \				->	   /   \	
		//		       8				  	   6				 5		8
		//	 	   	  /			  		        \
		//	  		6					         8
		
		// r-r rotation
		//				10						10		
		//			  /	  \					  /	   \
		//			5		20				 6		20
		//		  	  \				->	   /   \
		//		        6				 5       7
		//	 			  \
		//	  				7
		// when height violates, it falls into one of the above cases for rotation 
		
		AvlTree avlt = new AvlTree();
		root = avlt.insert(root, 10);
		avlt.insert(root, 5);
		avlt.insert(root, 20);
		avlt.insert(root, -10);
		//avlt.insert(root, -20);	//l-1
		avlt.insert(root, 3);
		avlt.insert(root, 30);
		//avlt.insert(root, 40);	//r-r
		avlt.insert(root, 25);
		
		inorder(root);
	}
	private AvlNode insert(AvlNode root, int data) {
		if(root == null) {
			return new AvlNode(data, 1);
		}
		if(data <= root.data) {
			root.left = insert(root.left, data);
			root.height = root.left.height+1;
		}else {
			root.right = insert(root.right, data);
			root.height = root.right.height+1;
		}
		int balace = height(root.left) - height(root.right);
		if(balace > 1) {
			if(height(root.left.left) > height(root.left.right)) {
				root = rotationRight(root);
			}else {
				root.left = rotationLeft(root.left);
				root = rotationRight(root);
			}
		}else if(balace < -1) {
			if(height(root.right.left) < height(root.right.right)) {
				root = rotationLeft(root);
			}else {
				root.right = rotationRight(root.right);
				root = rotationLeft(root);
			}
		}
		return root;
	}
	private AvlNode rotationRight(AvlNode root) {
		AvlNode newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		root.height = Math.max(height(root.left), height(root.right))+1;
		newRoot.height = Math.max(height(newRoot.left), height(newRoot.right))+1;
		
		return newRoot;
	}
	private AvlNode rotationLeft(AvlNode root) {
		AvlNode newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;
		root.height = Math.max(height(root.left), height(root.right))+1;
		newRoot.height = Math.max(height(newRoot.left), height(newRoot.right))+1;
		
		return newRoot;
	}
	private int height(AvlNode root) {
		if(root == null) {
			return 0;
		}
		return root.height;
	}
	private static void inorder(AvlNode root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	

}
