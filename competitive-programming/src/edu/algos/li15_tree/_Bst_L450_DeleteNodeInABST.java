package edu.algos.li15_tree;

import edu.algos.li00_model.TreeNode;

public class _Bst_L450_DeleteNodeInABST {
    public static void main(String[] args) {
        _Bst_L450_DeleteNodeInABST obj = new _Bst_L450_DeleteNodeInABST();

        _Bst_L701_InsertIntoABinarySearchTree bst = new _Bst_L701_InsertIntoABinarySearchTree();
        TreeNode root = bst.insertIntoBST(null, 10);
        bst.insertIntoBST(root, 2);
        bst.insertIntoBST(root, 4); 
        bst.insertIntoBST(root, 6);
        bst.insertIntoBST(root, 5);
        bst.insertIntoBST(root, 15);
        bst.insertIntoBST(root, 3);

        System.out.println(obj.deleteNode(root, 15));
    }

    // Problem: https://leetcode.com/problems/delete-node-in-a-bst/
    // Idea:Do binary search. Once root is found, they are 4 cases you need to handle for deletion.
    public TreeNode deleteNode(TreeNode root, int data) {
        if (root == null)
            return null;

        if (data < root.val) {
            root.left = deleteNode(root.left, data);
        } else if (data > root.val) {
            root.right = deleteNode(root.right, data);
        } else {
            if (root.left == null && root.right == null) {      // leaf node
                return null;
            } else if (root.left == null) {     // one child
                return root.right;
            } else if (root.right == null) {    // one child
                return root.left;
            } else {                            // two childs
                TreeNode succParent = root;
                TreeNode succ = root.right;

                while (succ.left != null) {
                    succParent = succ;
                    succ = succ.left;
                }
                if (succParent != root) {
                    succParent.left = succ.right;
                } else {
                    root.right = succ.right;
                }
                root.val = succ.val;
                return root;
            }
        }

        return root;
    }
}
