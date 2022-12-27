package edu.algos.li15_tree.medium;

import edu.algos.li00_model.TreeNode;

public class L235_LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        L235_LowestCommonAncestorOfABinarySearchTree obj = new L235_LowestCommonAncestorOfABinarySearchTree();

        L701_InsertIntoABinarySearchTree bst = new L701_InsertIntoABinarySearchTree();
        TreeNode root = bst.insertIntoBST(null, 10);
		bst.insertIntoBST(root, 2);
		bst.insertIntoBST(root, 4);
		bst.insertIntoBST(root, 6);
		bst.insertIntoBST(root, 5);
		bst.insertIntoBST(root, 15);
		bst.insertIntoBST(root, 3);

        System.out.println(obj.lowestCommonAncestor(root, root, root));
    }

    // Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    // Idea: If one value is on smaller then the root another one is larger, then that is lca.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
}
