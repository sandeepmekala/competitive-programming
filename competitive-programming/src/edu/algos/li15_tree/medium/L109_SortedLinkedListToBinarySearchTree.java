package edu.algos.li15_tree.medium;

import edu.algos.li00_model.TreeNode;
import edu.algos.li14_linkedlist._A01_SingleLinkedList;
import edu.algos.li15_tree._A02_BinarySearchTree;

public class L109_SortedLinkedListToBinarySearchTree {

	public static void main(String[] args) {
		L109_SortedLinkedListToBinarySearchTree obj = new L109_SortedLinkedListToBinarySearchTree();

		_A01_SingleLinkedList list = new _A01_SingleLinkedList();
		_A02_BinarySearchTree bst = new _A02_BinarySearchTree();

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
	 * Problem: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
	 * Idea: Head pointer is global for all recursive calls and it keeps on moving to right once every root node is built.
	 * We should do inorder travelsal to build BST as first element in the list is left most element in BST.
	 * We have to pass n. This helps us in building the tree in recursive way by splitting the elements in halfs.
	 * 
	 * */
	public TreeNode sortedListToBst(_A01_SingleLinkedList list, int n) {
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