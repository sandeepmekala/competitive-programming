package  com.algos.topics.li10_tree.bt;

import com.algos.topics.models.TreeNode;


public class Bt_L129_SumRootToLeafNumbers {

	public static void main(String[] args) {
		Bt_L129_SumRootToLeafNumbers obj = new Bt_L129_SumRootToLeafNumbers();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);

		System.out.println(obj.sumNumbers(root));
	}

	/*
	 * Problem: https://leetcode.com/problems/sum-root-to-leaf-numbers/
	 * Companies: Amazon
	 * Idea: Nums can be calculated from top down. Hence, calculate the number so far and pass as arg to childs.
	 * At the leave node full nums will be formed.
	 * Sum the two nums formed by left and right branches as they would have formed different nums.
	 * */
	public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int sum){
        if(root == null)
			return 0;

        if(root.left == null && root.right == null)
			return sum*10+root.val;

        return sumNumbers(root.left, sum*10+root.val) + sumNumbers(root.right, sum*10+root.val);
    }

}
