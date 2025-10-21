package  com.algos.topics.li10_tree.bt.revised;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.algos.topics.models.TreeNode;

public class Bt_L145_BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        Bt_L145_BinaryTreePostorderTraversal obj = new Bt_L145_BinaryTreePostorderTraversal();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);

        System.out.println(obj.postorderTraversal(root));
        System.out.println(obj.postorderIterativeTwoStacks(root));
        System.out.println(obj.postorderIterativeOneStack(root));
    }

    // Problem: https://leetcode.com/problems/binary-tree-postorder-traversal/
    // l-r-rt
	// Time: O(n)
    // space: O(1)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }

    private void postorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null)
			return;
		postorderTraversal(root.left, list);
		postorderTraversal(root.right, list);
		list.add(root.val);
    }

	// Time: O(n)
    // space: O(1)
    public List<Integer> postorderIterativeTwoStacks(TreeNode root) {
		if(root == null)
			return new ArrayList<>();

			Stack<TreeNode> stack1 = new Stack<TreeNode>();
			Stack<TreeNode> stack2 = new Stack<TreeNode>();
			stack1.push(root);
			while(!stack1.isEmpty()) {
				TreeNode curr = stack1.pop();
			stack2.push(curr);

			if(curr.left != null)
			stack1.push(curr.left);
			if(curr.right != null)
			stack1.push(curr.right);
		}

		List<Integer> postorder = new ArrayList<Integer>();
		while(!stack2.isEmpty()) {
			TreeNode curr = stack2.pop();
			postorder.add(curr.val);
		}

        return postorder;
	}

	// Similar, like inorder
	public List<Integer> postorderIterativeOneStack(TreeNode root) {
		if(root == null)
			return new ArrayList<Integer>();

        List<Integer> postorder = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;
		while(!stack.isEmpty() || curr != null) {
			if(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}else{
				TreeNode right = stack.peek().right;
				if(right == null) {
					right = stack.pop();
					postorder.add(right.val);
					while(!stack.isEmpty() && right == stack.peek().right){
						right = stack.pop();
						postorder.add(right.val);
					}
				}else {
					curr = right;
				}
			}
		}

        return postorder;
	}
}
