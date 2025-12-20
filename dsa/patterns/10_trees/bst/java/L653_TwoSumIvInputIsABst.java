import java.util.HashSet;

import com.algos.topics.models.TreeNode;

public class L653_TwoSumIvInputIsABst {

	public static void main(String[] args) {
		L653_TwoSumIvInputIsABst obj = new L653_TwoSumIvInputIsABst();

		L701_InsertIntoABinarySearchTree bst = new L701_InsertIntoABinarySearchTree();
		TreeNode root = bst.insertIntoBST(null, 10);
		bst.insertIntoBST(root, 2);
		bst.insertIntoBST(root, 4);
		bst.insertIntoBST(root, 6);
		bst.insertIntoBST(root, 5);
		bst.insertIntoBST(root, 15);
		bst.insertIntoBST(root, 3);

		System.out.println(obj.findTarget(root, 10));
	}

	// Problem: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
	// Idea: Similar like two sum. Use HashSet and pass it to each recursive call.
	// Do preorder traversal in BST and check if k-root.val is exist in set.
	//
	// Alternative: You can implement the same using BST iterator by implementing
	// next and before.
	// Next and before will be traversing on sorted nums, use two pointed logic to
	// find matching nums.
	// Time: O(n)
	// space: O(1)
	public boolean findTarget(TreeNode root, int k) {
		HashSet<Integer> set = new HashSet<>();
		return findTarget(root, k, set);
	}

	private boolean findTarget(TreeNode root, int k, HashSet<Integer> set) {
		if (root == null)
			return false;

		if (set.contains(k - root.val))
			return true;

		set.add(root.val);
		return findTarget(root.left, k, set) || findTarget(root.right, k, set);
	}

}
