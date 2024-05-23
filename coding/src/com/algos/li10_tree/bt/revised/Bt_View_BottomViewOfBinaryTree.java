package  com.algos.li10_tree.bt.revised;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import  com.algos.li30_model.TreeNode;

public class Bt_View_BottomViewOfBinaryTree {
    public static void main(String[] args) {
        Bt_View_BottomViewOfBinaryTree obj = new Bt_View_BottomViewOfBinaryTree();

        TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
        root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(obj.bottomView(root));
    }

    // Idea: Use column number logic. Do col-1 when you are left and col+1 when going right.
    // Time: O(n)
    // space: O(1)
    public List<Integer> bottomView(TreeNode root){
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0));
        while(!q.isEmpty()){
            Tuple pair = q.remove();
            TreeNode node = pair.node;
            int col = pair.col;

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