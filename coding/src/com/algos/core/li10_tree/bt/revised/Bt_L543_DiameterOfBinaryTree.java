package  com.algos.core.li10_tree.bt.revised;

import com.algos.core.models.TreeNode;


public class Bt_L543_DiameterOfBinaryTree {

	public static void main(String[] args) {
		Bt_L543_DiameterOfBinaryTree obj = new Bt_L543_DiameterOfBinaryTree();

        TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);

		System.out.println(obj.diameterOfBinaryTree(root));
	}

    // Problem: https://leetcode.com/problems/diameter-of-binary-tree/
    // Idea: At each node we have to return max len of if left and right paths.
    // And also, max diameter can be found anywhere in the tree. This also need to be bubbled up.
    // If we bubble this max, it gets complex as we need to max of curr root, max came from left and right.
    // To simplify this we use global max variable.
    // Time: O(n)
    // space: O(1)
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;

        int[] diameter = new int[1];
        depth(root, diameter);
        return diameter[0];
    }

    // we returning to parent it adds 1 for the edge it connected to parent.
    // Parent should just take max of left and right heights
    private int depth(TreeNode root, int[] diameter) {
		if(root == null)
			return 0;

		int leftDepth = depth(root.left, diameter);
		int rightDepth = depth(root.right, diameter);

		diameter[0] = Math.max(diameter[0], leftDepth+rightDepth);

		return 1 + Math.max(leftDepth, rightDepth);
    }
}
