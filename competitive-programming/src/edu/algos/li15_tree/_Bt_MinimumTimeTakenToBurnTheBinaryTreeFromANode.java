package edu.algos.li15_tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import edu.algos.li30_model.TreeNode;

public class _Bt_MinimumTimeTakenToBurnTheBinaryTreeFromANode {
    public static void main(String[] args) {
        //_Bt_MinimumTimeTakenToBurnTheBinaryTreeFromANode obj = new _Bt_MinimumTimeTakenToBurnTheBinaryTreeFromANode();

    }

    // Problem: https://www.geeksforgeeks.org/minimum-time-to-burn-a-tree-starting-from-a-leaf-node/
    // time: O(n)
    // space: O(1)
    public int burn(TreeNode root, TreeNode target) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParent(root, parent);

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.add(target);
        int level = 0;
        while(!q.isEmpty()){
            boolean burnt = false;
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.remove();
                if(node.left != null && !visited.contains(node.left)){
                    visited.add(node.left);
                    q.add(node.left);
                    burnt = true;
                }
                if(node.right != null && !visited.contains(node.right)){
                    visited.add(node.right);
                    q.add(node.right);
                    burnt = true;
                }
                if(parent.get(node) != null && !visited.contains(parent.get(node))){
                    visited.add(parent.get(node));
                    q.add(parent.get(node));
                    burnt = true;
                }
            }

            if(burnt)
                level++;
        }

        return level;
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
