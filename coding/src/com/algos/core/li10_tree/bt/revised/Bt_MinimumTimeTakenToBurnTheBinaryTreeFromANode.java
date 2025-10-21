package  com.algos.core.li10_tree.bt.revised;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.algos.core.models.TreeNode;

public class Bt_MinimumTimeTakenToBurnTheBinaryTreeFromANode {
    public static void main(String[] args) {
        Bt_MinimumTimeTakenToBurnTheBinaryTreeFromANode obj = new Bt_MinimumTimeTakenToBurnTheBinaryTreeFromANode();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(obj.burn(root, root.left));

    }

    // Problem: https://www.geeksforgeeks.org/minimum-time-to-burn-a-tree-starting-from-a-leaf-node/
    // Time: O(n)
    // space: O(1)
    public int burn(TreeNode root, TreeNode target) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        markParent(root, parents);

        Set<TreeNode> vis = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        vis.add(target);
        int level = 0;
        while(!q.isEmpty()){
            boolean burnt = false;
            for(int i=0; i<q.size(); i++){
                TreeNode node = q.remove();
                if(node.left != null && !vis.contains(node.left)){
                    vis.add(node.left);
                    q.add(node.left);
                    burnt = true;
                }
                if(node.right != null && !vis.contains(node.right)){
                    vis.add(node.right);
                    q.add(node.right);
                    burnt = true;
                }
                if(parents.get(node) != null && !vis.contains(parents.get(node))){
                    vis.add(parents.get(node));
                    q.add(parents.get(node));
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
