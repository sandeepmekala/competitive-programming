package edu.algos.li15_tree.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import edu.algos.li00_model.TreeNode;


public class _Bt_L103_BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        _Bt_L103_BinaryTreeZigzagLevelOrderTraversal obj = new _Bt_L103_BinaryTreeZigzagLevelOrderTraversal();

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
				TreeNode current = queue.remove();
                if(leftToRight) level.add(current.val);
                else level.add(0, current.val);

                if(current.left != null)
                    queue.add(current.left);    
                if(current.right != null)
                    queue.add(current.right);
			}
            leftToRight = !leftToRight;
            result.add(level);    
		}
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
		
		Stack<TreeNode> stack1 = new Stack<TreeNode>(); //rl
		Stack<TreeNode> stack2 = new Stack<TreeNode>(); //lr 
		stack1.push(root);
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
			while(!stack1.isEmpty()) {
				TreeNode current = stack1.pop();
				level.add(current.val);
				if(current.left != null) {
					stack2.push(current.left);
				}
				if(current.right != null) {
					stack2.push(current.right);
				}
			}
            if(!level.isEmpty()){
                result.add(level);    
            }
            
            level = new ArrayList<Integer>();
			while(!stack2.isEmpty()) {
				TreeNode current = stack2.pop();
				level.add(current.val);
				if(current.right != null) {
					stack1.push(current.right);			//right first
				}
				if(current.left != null) {
					stack1.push(current.left);
				}
			}
            if(!level.isEmpty()){
                result.add(level);    
            }
		}
        
        return result;
    }
}
