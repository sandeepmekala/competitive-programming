package edu.algos.li15_tree.medium;

import java.util.LinkedList;
import java.util.Queue;

import edu.algos.li00_model.TreeNode;

public class Bt_662_MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        Bt_662_MaximumWidthOfBinaryTree obj = new Bt_662_MaximumWidthOfBinaryTree();
        
        TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(obj.widthOfBinaryTree(root));
    }

    // Problem: https://leetcode.com/problems/maximum-width-of-binary-tree/
    // Idea: Index each node in bt similar like segment tree with 2*i+1, 2*I+2.
    // width is diff of last node and first node indices in each level. Take max of it.
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int first = 0, last = 0;
            int min = q.peek().index;
            for(int i=0; i<size; i++){
                Pair pair = q.remove();
                TreeNode node = pair.node;
                int index = pair.index-min;

                if(i==0) first = index;
                if(i==size-1) last = index;

                if(node.left != null) 
                    q.add(new Pair(node.left, 2*index+1));
                if(node.right != null) 
                    q.add(new Pair(node.right, 2*index+2));
            } 

            ans = Math.max(ans, last-first+1);
        }

        return ans;
    }

}
class Pair{
    TreeNode node;
    int index;
    public Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
    
}
