package edu.algos.li15_tree;

import java.util.ArrayList;
import java.util.Arrays;

import edu.algos.li00_model.TreeNode;

public class SerializeAndDeserializeBinaryTree {

	public static void main(String[] args) {
		SerializeAndDeserializeBinaryTree obj = new SerializeAndDeserializeBinaryTree();

		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.insert(null, 1, null);
		TreeNode n1 = bt.insert(root, 3, "l");
		TreeNode n2 = bt.insert(root, 4, "r");
		TreeNode n3 = bt.insert(n1, 2, "l");
		TreeNode n4 = bt.insert(n1, 6, "r");
		TreeNode n5 = bt.insert(n4, 5, "l");

		String serialized = obj.serialize(root);
		root = obj.deserialize(serialized);
		bt.inorder(root);
		;
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		ArrayList<String> serialized = new ArrayList<String>();
		serialize(root, serialized);
		System.out.println(serialized);
		return String.join(",", serialized);
	}

	private void serialize(TreeNode root, ArrayList<String> serialized) {
		if (root != null) {
			serialized.add(root.val + "");
			serialize(root.left, serialized);
			serialize(root.right, serialized);
		} else {
			serialized.add("null");
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		ArrayList<String> serialized = new ArrayList<String>(Arrays.asList(data.split(",")));
		TreeNode root = deserialize(serialized);
		return root;
	}

	private TreeNode deserialize(ArrayList<String> serialized) {
		String val = serialized.remove(0);
		if (val.equals("null")) {
			return null;
		}
		
		TreeNode root = new TreeNode(Integer.parseInt(val));
		root.left = deserialize(serialized);
		root.right = deserialize(serialized);
		return root;
	}
}
