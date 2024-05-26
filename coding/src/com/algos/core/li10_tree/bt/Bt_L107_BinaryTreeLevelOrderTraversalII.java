package  com.algos.core.li10_tree.bt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import  com.algos.core.li30_model.TreeNode;

public class Bt_L107_BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        Bt_L107_BinaryTreeLevelOrderTraversalII obj = new Bt_L107_BinaryTreeLevelOrderTraversalII();

        		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);

        System.out.println(obj.levelOrderBottom(root));;
    }

    // Problem: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
    // Idea: Need 2 queues if you want to print level by level.
    // Instead of using the 2nd queue, rely on 1st queue size and process the queue element until its size. Keep insert elements into same queue.
    // We have to insert the level list at the begin of linked list as want them in reverse order.
    // Time: O(n)
    // space: O(n)
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root == null)
            return result;
            
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		q.add(root);
		while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = q.size();
			for(int i=0; i<size; i++) {
				TreeNode curr = q.remove();
				level.add(curr.val);
                if(curr.left != null)
                    q.add(curr.left);    
                if(curr.right != null)
                    q.add(curr.right);
			}

            result.addFirst(level);    
		}

        return result;
    }
}
