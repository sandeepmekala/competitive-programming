package  com.algos.core.li10_tree.bst.revised;

import  com.algos.core.li30_model.TreeNode;

public class L1008_ConstructBinarySearchTreefromPreorderTraversal {
    public static void main(String[] args) {
        L1008_ConstructBinarySearchTreefromPreorderTraversal obj = new L1008_ConstructBinarySearchTreefromPreorderTraversal();
        
        int[] preorder = new int[]{8,5,1,7,10,12};
        obj.bstFromPreorder(preorder);
    }

    // Problem: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
    // Idea: Pass range from top to bottom. If the current element in preorder in that range, prepare a node, else return null;
    // While going left the current root val become upper bound, but while going to right the bound that came from its parent becomes bound.
    // Lower bound id automatically take by greedy just pass upper bound.
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private TreeNode bstFromPreorder(int[] preorder, int bound, int[] i) {
        if(i[0]==preorder.length || preorder[i[0]] > bound)
            return null;
        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = bstFromPreorder(preorder, root.val, i);
        root.right = bstFromPreorder(preorder, bound, i);
        return root;
    }
}
