package  com.algos.core.li10_tree.bt.revised;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import  com.algos.core.li30_model.TreeNode;

public class Bt_View_TopViewOfBinaryTree {
    public static void main(String[] args) {
        Bt_View_TopViewOfBinaryTree obj = new Bt_View_TopViewOfBinaryTree();
        
        TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
        root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(obj.topView(root));
    }

    // Problem: https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
    // Idea: Use column number logic. Do col-1 when you are left and col+1 when going right.
    // Time: O(n)
    // space: O(1)
    public List<Integer> topView(TreeNode root){
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0));
        while(!q.isEmpty()){
            Tuple curr = q.remove();
            TreeNode node = curr.node;
            int col = curr.col;

            if(!map.containsKey(col)) 
                map.put(col, node.val);

            if(node.left !=  null) 
                q.add(new Tuple(node.left, col-1));
            if(node.right !=  null) 
                q.add(new Tuple(node.right, col+1));
        }
        
        List<Integer> ans = new ArrayList<>();
        for(Integer val: map.values()){
            ans.add(val);
        }
        return ans;
    }
}
class Tuple{
    TreeNode node;
    int col;
    public Tuple(TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}
