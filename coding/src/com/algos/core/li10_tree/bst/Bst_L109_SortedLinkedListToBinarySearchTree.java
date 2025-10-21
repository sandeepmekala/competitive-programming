package  com.algos.core.li10_tree.bst;

import com.algos.core.li09_linkedlist.revised.SingleLinkedList;
import com.algos.core.li10_tree.bst.revised.L701_InsertIntoABinarySearchTree;
import com.algos.core.models.TreeNode;

public class Bst_L109_SortedLinkedListToBinarySearchTree {

	public static void main(String[] args) {
		Bst_L109_SortedLinkedListToBinarySearchTree obj = new Bst_L109_SortedLinkedListToBinarySearchTree();

		SingleLinkedList list = new SingleLinkedList();
		L701_InsertIntoABinarySearchTree bst = new L701_InsertIntoABinarySearchTree();

		list.insertBeforeHead(7);
		list.insertBeforeHead(6);
		list.insertBeforeHead(5);
		list.insertBeforeHead(4);
		list.insertBeforeHead(3);
		list.insertBeforeHead(2);
		list.insertBeforeHead(1);

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
	public TreeNode sortedListToBst(SingleLinkedList list, int n) {
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
