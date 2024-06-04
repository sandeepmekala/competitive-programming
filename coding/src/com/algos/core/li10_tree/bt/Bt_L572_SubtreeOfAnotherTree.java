package  com.algos.core.li10_tree.bt;

import  com.algos.core.li30_model.TreeNode;


public class Bt_L572_SubtreeOfAnotherTree {

	public static void main(String[] args) {
		Bt_L572_SubtreeOfAnotherTree obj = new Bt_L572_SubtreeOfAnotherTree();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
		
		System.out.println(obj.isSubtree(root, root));
	}

	// Problem: https://leetcode.com/problems/subtree-of-another-tree
	// Idea: For each node check if same tree. If not check both in left and right subtrees.
	// Same tree will return quickly if roots are not matching. If roots are matching, then only it will continue.
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;
        
        if(isSameTree(root, subRoot))
            return true;
            
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
		if(root1 == null || root2 == null)
			return root1 == root2;
		
        return (root1.val == root2.val) && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
	}
}
