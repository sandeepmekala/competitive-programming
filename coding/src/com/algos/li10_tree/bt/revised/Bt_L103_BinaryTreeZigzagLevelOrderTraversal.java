package  com.algos.li10_tree.bt.revised;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import  com.algos.li30_model.TreeNode;


public class Bt_L103_BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Bt_L103_BinaryTreeZigzagLevelOrderTraversal obj = new Bt_L103_BinaryTreeZigzagLevelOrderTraversal();

        TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);

        System.out.println(obj.zigzagLevelOrder(root));
    }

    // Problem: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    // Idea: Similar, to levelorder traversal. Just use a flag to denote whether to insert element in list from left to right or right to left.
    // Time: O(n)
    // space: O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
            
        boolean leftToRight = true;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<Integer>(size);
			for(int i=0; i<size; i++) {
				TreeNode curr = queue.remove();
                level.add(curr.val);

                if(curr.left != null)
                    queue.add(curr.left);    
                if(curr.right != null)
                    queue.add(curr.right);
			}
            if(!leftToRight)
               Collections.reverse(level);

            leftToRight = !leftToRight;
            result.add(level);    
		}
        return result;
    }
}
