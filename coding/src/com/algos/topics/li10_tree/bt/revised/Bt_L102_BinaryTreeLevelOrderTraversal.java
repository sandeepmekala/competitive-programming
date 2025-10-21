package  com.algos.topics.li10_tree.bt.revised;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.algos.topics.models.TreeNode;


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
    // Idea: Rely on queue size and process the queue elements until its size. Keep insert elements into same queue.
    // Time: O(n)
    // space: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;

        Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();                // Take to a variable as q size changes
			for(int i=0; i<size; i++) {
				TreeNode curr = q.remove();
				level.add(curr.val);
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
			}

            ans.add(level);
		}
        return ans;
    }
}
