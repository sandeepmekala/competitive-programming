package edu.algos.li15_tree;

import edu.algos.li00_model.TreeNode;
import edu.algos.li14_linkedlist._A01_SingleLinkedList;

public class SortedLinkedListToBinarySearchTree {

	public static void main(String[] args) {
		SortedLinkedListToBinarySearchTree obj = new SortedLinkedListToBinarySearchTree();

		_A01_SingleLinkedList list = new _A01_SingleLinkedList();
		BinarySearchTree bst = new BinarySearchTree();

		list.insertAtBegining(7);
		list.insertAtBegining(6);
		list.insertAtBegining(5);
		list.insertAtBegining(4);
		list.insertAtBegining(3);
		list.insertAtBegining(2);
		list.insertAtBegining(1);

		System.out.println("Given Linked List ");
		list.print();

		TreeNode root = obj.sortedListToBst(list, list.size());
		System.out.println();
		System.out.println("Pre-Order Traversal of constructed BST ");
		bst.preorder(root);
	}

	/*
	 * Idea: head pointer is global for all recursive calls.
	 * 
	 * */
	TreeNode sortedListToBst(_A01_SingleLinkedList list, int n) {
		if (n <= 0)
			return null;

		// Recursively construct the left subtree
		TreeNode left = sortedListToBst(list, n / 2);

		// head ref now refers to middle node, make middle node as root of BST
		TreeNode root = new TreeNode(list.head.val);

		// Set pointer to left subtree
		root.left = left;

		// Change head pointer of Linked List for parent recursive calls
		list.head = list.head.next;

		// Recursively construct the right subtree and link it with root. The number of
		// nodes in right subtree is total nodes - nodes in left subtree - 1 (for root)
		root.right = sortedListToBst(list, n - n / 2 - 1);

		return root;
	}
}