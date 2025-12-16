
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.algos.topics.models.TreeNode;


public class Bt_L297_SerializeAndDeserializeBinaryTree {

	public static void main(String[] args) {
		Bt_L297_SerializeAndDeserializeBinaryTree obj = new Bt_L297_SerializeAndDeserializeBinaryTree();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);

		String serialized = obj.serialize(root);
		System.out.println(serialized);
		root = obj.deserialize(serialized);
		//bt.inorder(root);
	}

	// Problem: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
	// Idea: For encoding, load the elements in preorder traversal into list
	// For decoding, go in preorder. Always remove first element from list to build root node of preorder.
	// Recursively pass the same list which removes the first elements from the list to build respective preoder nodes.
	// Time: O(n)
    // space: O(1)
	public String serialize(TreeNode root) {
		List<String> serialized = new ArrayList<>();
		serialize(root, serialized);
		return String.join(",", serialized);
	}

	private void serialize(TreeNode root, List<String> serialized) {
		if (root == null) {
			serialized.add("#");
			return;
		}
		serialized.add(String.valueOf(root.val));
		serialize(root.left, serialized);
		serialize(root.right, serialized);
	}

	public TreeNode deserialize(String data) {
		List<String> serialized = Arrays.asList(data.split(","));
		return deserialize(serialized);
	}

	private TreeNode deserialize(List<String> serialized) {
		String val = serialized.remove(0);
		if (val.equals("#"))
			return null;

		TreeNode root = new TreeNode(Integer.parseInt(val));
		root.left = deserialize(serialized);
		root.right = deserialize(serialized);
		return root;
	}
}
