package  com.algos.core.li10_tree.bt.revised;

import java.util.LinkedList;
import java.util.Queue;

import  com.algos.core.li30_model.TreeNode;

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
    // Idea: Index each node in bt similar like segment tree with 2*i+1, 2*i+2.
    // width is diff of last node and first node indices in each level. Take max of it.
    // Time: O(n)
    // space: O(1)
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) 
            return 0;

        int ans = 0;
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int first = -1, last = -1;
            int min = q.peek().index;
            
            for(int i=0; i<size; i++){
                Tuple curr = q.remove();
                TreeNode node = curr.node;
                int index = curr.index-min;

                if(i==0) first = index;
                if(i==size-1) last = index;

                if(node.left != null) 
                    q.add(new Tuple(node.left, 2*index+1));
                if(node.right != null) 
                    q.add(new Tuple(node.right, 2*index+2));
            } 

            ans = Math.max(ans, last-first+1);
        }

        return ans;
    }

}
class Tuple{
    TreeNode node;
    int index;
    public Tuple(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
