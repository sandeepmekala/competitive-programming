package li10_tree.bt;

import com.algos.topics.models.TreeNode;

public class Bt_L100_SameTree {
    public static void main(String[] args) {
        Bt_L100_SameTree obj = new Bt_L100_SameTree();

        TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);

        System.out.println(obj.isSameTree(root, root));
    }

    // Problem: https://leetcode.com/problems/same-tree/
    // Idea: Root values should be same and left and right sub trees should be same trees.
    // Time: O(n)
    // space: O(1)
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
		if(root1 == null || root2 == null)
			return root1 == root2;

        return (root1.val == root2.val) && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
	}
}
