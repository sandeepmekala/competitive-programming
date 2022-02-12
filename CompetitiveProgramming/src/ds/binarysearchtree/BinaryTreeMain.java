package ds.binarysearchtree;

import java.util.Stack;

public class BinaryTreeMain {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		
		Node root = bt.insert(null, 1, null);
		Node n1 = bt.insert(root, 3, "l");
		Node n2 = bt.insert(root, 2, "r");
		Node n3 = bt.insert(n1, 4, "l");
		Node n4 = bt.insert(n1, 6, "r");
		Node n5 = bt.insert(n4, 5, "l");
		
		bt.preorder(root);
		System.out.println();
		Stack st = bt.pathToXAsArray(root, 5);
		//System.out.println(bt.pathToXAsArray(root, 5));
		System.out.println(st.pop());
	}

}
