package edu.algos.tree;

import edu.ds.linkedlists.SingleLinkedList;
import edu.ds.trees.BinarySearchTree;
import edu.ds.trees.model.TreeNode;

public class SortedLinkedListToBinarySearchTree {

	public static void main(String[] args) {
		SortedLinkedListToBinarySearchTree obj = new SortedLinkedListToBinarySearchTree();

		SingleLinkedList list = new SingleLinkedList();
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

		TreeNode root = obj.sortedListToBst(list, list.count());
		System.out.println();
		System.out.println("Pre-Order Traversal of constructed BST ");
		bst.preorder(root);
	}

	TreeNode sortedListToBst(SingleLinkedList list, int n) {
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