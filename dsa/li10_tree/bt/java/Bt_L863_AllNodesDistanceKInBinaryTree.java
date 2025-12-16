
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.algos.topics.models.TreeNode;

public class Bt_L863_AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        Bt_L863_AllNodesDistanceKInBinaryTree obj = new Bt_L863_AllNodesDistanceKInBinaryTree();

        TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(obj.distanceK(root, root.left, 2));
    }

    // Problem: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
    // Idea: Create links to parent to treverse back to parents using a map.
    // Traverse in 2 direction by counting the level until k. When level becomes k, nodes will be in q.
    // Time: O(n)
    // space: O(1)
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParent(root, parent);

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.add(target);
        int level = 0;
        while(!q.isEmpty()){
            if(level == k)
                break;

            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.remove();
                if(node.left != null && !visited.contains(node.left)){
                    visited.add(node.left);
                    q.add(node.left);
                }
                if(node.right != null && !visited.contains(node.right)){
                    visited.add(node.right);
                    q.add(node.right);
                }
                if(parent.get(node) != null && !visited.contains(parent.get(node))){
                    visited.add(parent.get(node));
                    q.add(parent.get(node));
                }
            }
            level++;
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.remove().val);
        }

        return ans;
    }

    private void markParent(TreeNode root, Map<TreeNode, TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            if(node.left != null){
                parent.put(node.left, node);
                q.add(node.left);
            }
            if(node.right != null){
                parent.put(node.right, node);
                q.add(node.right);
            }
        }
    }
}
