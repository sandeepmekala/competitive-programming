package edu.algos.li14.tree;

import java.util.ArrayList;
import java.util.List;

import edu.algos.li00.model.TreeNode;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		BinaryTreeRightSideView obj = new BinaryTreeRightSideView();
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.insert(null, 1, null);
		TreeNode n1 = bt.insert(root, 3, "l");
		TreeNode n2 = bt.insert(root, 4, "r");
		TreeNode n3 = bt.insert(n1, 2, "l");
		TreeNode n4 = bt.insert(n1, 6, "r");
		TreeNode n5 = bt.insert(n4, 5, "l");
		
		System.out.println(obj.rightSideView(root));
	}

	List<Integer> result = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        inorder(root, 0);
        return result;
    }
    
    private void inorder(TreeNode root, int level){
        if(root != null){
            if(result.size() == level){
                result.add(root.val);
            }
            inorder(root.right, level+1);
            inorder(root.left, level+1);
        }
    }
}
