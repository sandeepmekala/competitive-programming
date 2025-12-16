package li10_tree.bst;

import com.algos.topics.models.TreeNode;

public class L450_DeleteNodeInABST {
    public static void main(String[] args) {
        L450_DeleteNodeInABST obj = new L450_DeleteNodeInABST();

        L701_InsertIntoABinarySearchTree bst = new L701_InsertIntoABinarySearchTree();
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
    // Idea:Do binary search. Once root is found, there are 3 cases you need to handle for deletion.
    // Time: O(logn)
    // space: O(1)
    public TreeNode deleteNode(TreeNode root, int data) {
        if (root == null)
            return null;

        if (data < root.val) {
            root.left = deleteNode(root.left, data);
        } else if (data > root.val) {
            root.right = deleteNode(root.right, data);
        } else {
            if (root.left == null) {            // no child or right child
                return root.right;
            } else if (root.right == null) {    // one child
                return root.left;
            } else {                            // two childs
                TreeNode successor = findSuccessor(root.right);
                root.val = successor.val;
                root.right = deleteNode(root.right, root.val);
            }
        }

        return root;
    }

    private TreeNode findSuccessor(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
