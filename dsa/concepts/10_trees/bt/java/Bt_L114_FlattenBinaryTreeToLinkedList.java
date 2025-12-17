
import com.algos.topics.models.TreeNode;


public class Bt_L114_FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		Bt_L114_FlattenBinaryTreeToLinkedList obj = new Bt_L114_FlattenBinaryTreeToLinkedList();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);

		//obj.flatten(root);
		obj.flatten2(root);
	}

	/*
	 * Problem: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
	 * Idea: Idea is to traverse in reverse postorder and flatten
	 * Use a global prev variable to track the last explored node in postorder traversal and assign it to right of current node.Then update the current as next previous for next iteration.
	 *
	 * */
	// Time: O(n)
    // space: O(1)
	TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null)
			return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

	// Idea:You can use Morris traversal to implement the same in interative mannar.
	// Instead of assigning prev.right to curr, assign it to curr.right and then update curr.right to left and left to null.
	// Time: O(n)
    // space: O(1)
	public void flatten2(TreeNode root) {
		TreeNode curr = root;
		while(curr != null){
			if(curr.left != null){
				TreeNode prev = curr.left;
				while(prev.right != null){
					prev = prev.right;
				}

				prev.right = curr.right;
				curr.right = curr.left;
				curr.left = null;
			}

			curr = curr.right;
		}
	}
}
