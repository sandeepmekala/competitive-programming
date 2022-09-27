package edu.algos.li14.tree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import edu.algos.li00.model.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public static void main(String[] args) {
		ConstructBinaryTreeFromPreorderAndInorderTraversal obj = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		
		BinaryTree bt = new BinaryTree();
		//TreeNode root = obj.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
		TreeNode root = obj.buildTree(new int[] {1,2}, new int[] {2,1});
		bt.inorder(root);
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		List<Integer> list1 = Arrays.stream(preorder).boxed().collect(Collectors.toList());
		List<Integer> list2 = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        return build(list1, list2);
    }
    
    private TreeNode build(List<Integer> preorder, List<Integer> inorder) {
        if(preorder.isEmpty() && inorder.isEmpty()){
            return null;
        }
        TreeNode root = new TreeNode(preorder.get(0));
        int mid = inorder.indexOf(preorder.get(0));
        root.left = build(preorder.subList(1, mid+1), inorder.subList(0, mid));
        root.right = build(preorder.subList(mid+1, preorder.size()), inorder.subList(mid+1, inorder.size()));
        return root;
	}
}