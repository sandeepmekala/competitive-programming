import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.algos.topics.models.TreeNode;

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
        Queue<Tuple2> q = new LinkedList<>();
        q.add(new Tuple2(root, 0));
        while(!q.isEmpty()){
            Tuple2 curr = q.remove();
            TreeNode node = curr.node;
            int col = curr.col;

            map.put(col, node.val);

            if(node.left !=  null)
                q.add(new Tuple2(node.left, col-1));
            if(node.right !=  null)
                q.add(new Tuple2(node.right, col+1));
        }
        return new ArrayList<>(map.values());
    }
}
class Tuple2{
    TreeNode node;
    int col;
    public Tuple2(TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}
