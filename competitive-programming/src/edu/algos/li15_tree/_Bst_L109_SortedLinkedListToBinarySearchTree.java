package edu.algos.li15_tree;

import edu.algos.li14_linkedlist._G01_SingleLinkedList;
import edu.algos.li30_model.TreeNode;

public class _Bst_L109_SortedLinkedListToBinarySearchTree {

	public static void main(String[] args) {
		_Bst_L109_SortedLinkedListToBinarySearchTree obj = new _Bst_L109_SortedLinkedListToBinarySearchTree();

		_G01_SingleLinkedList list = new _G01_SingleLinkedList();
		_Bst_L701_InsertIntoABinarySearchTree bst = new _Bst_L701_InsertIntoABinarySearchTree();

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
		//bst.preorder(root);
	}

	/*
	 * Problem: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
	 * Idea: Head pointer is global for all recursive calls and it keeps on moving to right once every root node is built.
	 * We should do inorder travelsal to build BST as first element in the list is left most element in BST.
	 * We have to pass n. This helps us in building the tree in recursive way by splitting the elements in halfs.
	 * 
	 * */
	public TreeNode sortedListToBst(_G01_SingleLinkedList list, int n) {
		if (n <= 0)
			return null;

		TreeNode left = sortedListToBst(list, n / 2);
		TreeNode root = new TreeNode(list.head.val);
		list.head = list.head.next;
		root.left = left;
		root.right = sortedListToBst(list, n - n / 2 - 1);

		return root;
	}
}