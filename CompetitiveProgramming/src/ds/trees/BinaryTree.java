package ds.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

import ds.stacks.ReverseStringUsingStack;

public class BinaryTree {
	private Node root;	
	
	public Node insert(Node root, int data, String side){
		Node node = new Node(data);
		if(root == null){
			return node;
		}
		if("l".equals(side)){
			root.setLeft(node);
			return node;
		}else if("r".equals(side)){
			root.setRight(node);
			return node;
		}else{
			throw new RuntimeException("Specify the side");
		}
		
	}
	public ArrayList<Integer> pathToXAsArray(Node root, int data){
		if(root == null){
			return new ArrayList<Integer>(Arrays.asList(-1));
		}
		if(data == root.getData()){
			return new ArrayList<Integer>(Arrays.asList(root.getData()));
		}
		
		ArrayList<Integer> leftPath = pathToXAsArray(root.getLeft(), data);
		if(leftPath.contains(data)) {
			leftPath.add(root.getData());
			return leftPath;
		}
		
		ArrayList<Integer> rightPath = pathToXAsArray(root.getRight(), data);
		if(rightPath.contains(data)) {
			rightPath.add(root.getData());
			return rightPath;
		}
		return new ArrayList<Integer>(Arrays.asList(-1));
	}
	public void preorder(Node root){		// rt-l-r
		if(root != null){	
			System.out.print(root.getData()+" ");
			preorder(root.getLeft());
			preorder(root.getRight());
		}
	}
	public void postoder(Node root){		// l-r-rt
		if(root != null){	
			preorder(root.getLeft());
			preorder(root.getRight());
			System.out.print(root.getData()+" ");
		}
	}
	public void inorder(Node root){			// l-rt-r
		if(root != null){	
			preorder(root.getLeft());
			System.out.print(root.getData()+" ");
			preorder(root.getRight());
		}
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public static void main(String[] args) {
		// -> root level is 0
		// -> level l can container at most 2^l nodes
		// -> height is the number of levels that tree has
		// -> max nodes in tree is 2^h-1
		// -> in BT of n node minimum possible height or minimum possible levels is log(n+1)
		// -> full BT: each node has 0 or 2 children
		// -> complete BT: all the node has 2 children and last level has filled from left
		// -> perfect BT: all the nodes have 2 children and all the leaves are at same level
		// -> Balanced BT: a tree with height lon(n). 
		//		-> AVL: maintains balance by making sure the height of left and right tree is at most 1
		//		-> RB: maintains the balance by making sure there are same number of black nodes from root to every leaf and there are not adjacent red nodes
		// -> degenerate(pathological) tree: every node has single child. It is kind of linked list.
		// -> traversals: inorder, preorder, postorder, breath first order(level order)
		
		//	 		1
		//		  /	  \
		//		3		2
		//	  /	  \		  
		//	4		6
		//		  /
		//		5
		
		BinaryTree bt = new BinaryTree();
		Node root = bt.insert(null, 1, null);
		Node n1 = bt.insert(root, 3, "l");
		Node n2 = bt.insert(root, 2, "r");
		Node n3 = bt.insert(n1, 4, "l");
		Node n4 = bt.insert(n1, 6, "r");
		Node n5 = bt.insert(n4, 5, "l");
		
		bt.preorder(root);
		System.out.println();
		ArrayList<Integer> path = bt.pathToXAsArray(root, 5);
		//System.out.println(bt.pathToXAsArray(root, 5));
		System.out.println(path);
	}

}
