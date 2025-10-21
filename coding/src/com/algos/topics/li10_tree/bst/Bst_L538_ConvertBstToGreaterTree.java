package  com.algos.topics.li10_tree.bst;

import com.algos.topics.li10_tree.bst.revised.L701_InsertIntoABinarySearchTree;
import com.algos.topics.models.TreeNode;

public class Bst_L538_ConvertBstToGreaterTree {

	public static void main(String[] args) {
		Bst_L538_ConvertBstToGreaterTree obj = new Bst_L538_ConvertBstToGreaterTree();

		L701_InsertIntoABinarySearchTree bst = new L701_InsertIntoABinarySearchTree();
		TreeNode root = bst.insertIntoBST(null, 10);
		bst.insertIntoBST(root, 2);
		bst.insertIntoBST(root, 4);
		bst.insertIntoBST(root, 6);
		bst.insertIntoBST(root, 5);
		bst.insertIntoBST(root, 15);
		bst.insertIntoBST(root, 3);

		System.out.println(obj.convertBST(root));
	}

	/*
	 * Problem: https://leetcode.com/problems/convert-bst-to-greater-tree/
	 * Companies: Amazon
	 * Idea: We need to process right first, get the rightSum, then update the root val as root+rightSum, then process left.
	 * Left child should get the sum its root+rightSum. Hence, we need to pass a sum varible.
	 *
	 * */
	public TreeNode convertBST(TreeNode root) {
        convertBst(root, 0);

        return root;
    }

    private int convertBst(TreeNode root, int sum){
        if(root == null)
			return sum;

        int rightSum = convertBst(root.right, sum);
        root.val = rightSum + root.val;
        return convertBst(root.left, root.val);
    }
}
