package  com.algos.li10_tree.bt.revised;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import  com.algos.li30_model.TreeNode;


public class Bt_L102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Bt_L102_BinaryTreeLevelOrderTraversal obj = new Bt_L102_BinaryTreeLevelOrderTraversal();
        
        TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);

        System.out.println(obj.levelOrder(root));
    }

    // Problem: https://leetcode.com/problems/binary-tree-level-order-traversal/
    // Idea: Rely on queue size and process the queue element until its size. Keep insert elements into same queue.
    // time: O(n)
    // space: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
            
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
			for(int i=0; i<size; i++) {
				TreeNode curr = queue.remove();
				level.add(curr.val);
                if(curr.left != null)
                    queue.add(curr.left);    
                if(curr.right != null)
                    queue.add(curr.right);
			}

            result.add(level);    
		}
        return result;
    }
}
