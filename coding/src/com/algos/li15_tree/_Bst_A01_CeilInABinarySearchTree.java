package  com.algos.li15_tree;

import  com.algos.li30_model.TreeNode;

public class _Bst_A01_CeilInABinarySearchTree {
    public static void main(String[] args) {
        _Bst_A01_CeilInABinarySearchTree obj = new _Bst_A01_CeilInABinarySearchTree();

        _Bst_L701_InsertIntoABinarySearchTree bst = new _Bst_L701_InsertIntoABinarySearchTree();
        TreeNode root = bst.insertIntoBST(null, 10);
		bst.insertIntoBST(root, 2);
		bst.insertIntoBST(root, 4);
		bst.insertIntoBST(root, 7);
		bst.insertIntoBST(root, 5);
		bst.insertIntoBST(root, 15);
		bst.insertIntoBST(root, 3);

        System.out.println(obj.findCeil(root, 6));
    }

    // Idea: when root val is larger, that could be one possible ceil value.
    // Assign it to ceild and try to minumize the ceil value by going left.
    // Floor of a num is also similar logic. 
    // time: O(logn)
    // space: O(1)
    public int findCeil(TreeNode root, int key){
        int ceil = -1;
        TreeNode curr = root;
        while(curr != null){
            if(curr.val >= key){
                ceil = curr.val;
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }

        return ceil;
    }
}
