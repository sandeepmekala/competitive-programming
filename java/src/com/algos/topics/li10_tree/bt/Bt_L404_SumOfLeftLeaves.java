package  com.algos.topics.li10_tree.bt;

import com.algos.topics.models.TreeNode;

public class Bt_L404_SumOfLeftLeaves {

	public static void main(String[] args) {
		Bt_L404_SumOfLeftLeaves obj = new Bt_L404_SumOfLeftLeaves();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);

		System.out.println(obj.sumOfLeftLeaves(root));

	}

	/*
	 * Problem: https://leetcode.com/problems/sum-of-left-leaves/
	 * Idea: As we need to differentiate between left and right, use a flag arg.
	 * */
	public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if(root == null)
			return 0;
        if(root.left == null && root.right == null)
            if(isLeft)
				return root.val;
            else
				return 0;

        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }

}
