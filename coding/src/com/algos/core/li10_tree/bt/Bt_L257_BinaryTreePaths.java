package  com.algos.core.li10_tree.bt;

import java.util.ArrayList;
import java.util.List;

import com.algos.core.models.TreeNode;

public class Bt_L257_BinaryTreePaths {

	public static void main(String[] args) {
		Bt_L257_BinaryTreePaths obj = new Bt_L257_BinaryTreePaths();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);

		System.out.println(obj.binaryTreePaths(root));
	}

	// Problem: https://leetcode.com/problems/binary-tree-paths/
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        String path = "";
        binaryTreePaths(root, path, result);
        return result;
    }

    private void binaryTreePaths(TreeNode root, String path, List<String> result) {
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            path += root.val;
            result.add(path);
        }else{
            path += root.val+"->";
            binaryTreePaths(root.left, path, result);
            binaryTreePaths(root.right, path, result);
        }
    }

}
