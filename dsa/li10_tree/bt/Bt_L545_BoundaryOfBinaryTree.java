package li10_tree.bt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.algos.topics.models.TreeNode;

public class Bt_L545_BoundaryOfBinaryTree {
    public static void main(String[] args) {
        Bt_L545_BoundaryOfBinaryTree obj = new Bt_L545_BoundaryOfBinaryTree();

        TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        System.out.println(obj.boundaryOfBinaryTree(root));
    }

    // Problem: https://leetcode.com/problems/boundary-of-binary-tree/
    // https://www.lintcode.com/problem/878
    // Idea: Traverse left path to get left boundry and do inorder and pick up only leaves, then do right traversal and get right boundry.
    // Time: O(n)
    // space: O(1)
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundry = new ArrayList<>();
        if(root == null)
            return boundry;
        if(!isLeaf(root))
            boundry.add(root.val);

        addLeftBoundry(root, boundry);
        addLeaves(root, boundry);
        addRightBoundry(root, boundry);

        return boundry;
    }

    private void addLeftBoundry(TreeNode root, List<Integer> boundry) {
        TreeNode curr = root.left;
        while(curr != null){
            if(!isLeaf(curr))
                boundry.add(curr.val);

            if(curr.left !=  null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    private void addRightBoundry(TreeNode root, List<Integer> boundry) {
        TreeNode curr = root.right;
        List<Integer> s = new ArrayList<>();
        while(curr != null){
            if(!isLeaf(curr))
                s.add(curr.val);

            if(curr.right !=  null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        Collections.reverse(s);
        boundry.addAll(s);
    }

    private void addLeaves(TreeNode root, List<Integer> boundry) {
        if(isLeaf(root)){
            boundry.add(root.val);
            return;
        }

        if(root.left != null)
            addLeaves(root.left, boundry);
        if(root.right != null)
            addLeaves(root.right, boundry);
    }

    private boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
}
