package  com.algos.li10_tree.bst.revised;

import  com.algos.li30_model.TreeNode;

public class L285_InorderSuccessorInBst {
    public static void main(String[] args) {
        L285_InorderSuccessorInBst obj = new L285_InorderSuccessorInBst();

        L701_InsertIntoABinarySearchTree bst = new L701_InsertIntoABinarySearchTree();
        TreeNode root = bst.insertIntoBST(null, 10);
		bst.insertIntoBST(root, 2);
		bst.insertIntoBST(root, 4);
		bst.insertIntoBST(root, 6);
		bst.insertIntoBST(root, 5);
		bst.insertIntoBST(root, 15);
		bst.insertIntoBST(root, 3);

        System.out.println(obj.inorderSuccessor(root, new TreeNode(5)));
    }

    // Problem: https://leetcode.com/problems/inorder-successor-in-bst/
    // https://www.lintcode.com/problem/448/
    // Idea: Similar like ceil in binary search. Track succ and continueosly update succ if you fine better succ.
    // time: O(logn)
    // space: O(1)
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode curr = root, succ = null;
        while(curr != null){
            if(curr.val > p.val){
                succ = curr;
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }

        return succ;
    }

}
