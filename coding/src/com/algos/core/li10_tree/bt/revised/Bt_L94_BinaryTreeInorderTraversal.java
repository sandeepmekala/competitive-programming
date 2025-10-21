package  com.algos.core.li10_tree.bt.revised;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.algos.core.models.TreeNode;

public class Bt_L94_BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        Bt_L94_BinaryTreeInorderTraversal obj = new Bt_L94_BinaryTreeInorderTraversal();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);

        System.out.println(obj.inorderTraversal(root));
        System.out.println(obj.inorderIterative(root));
        System.out.println(obj.morrisInorder(root));
    }

    // Problem: https://leetcode.com/problems/binary-tree-inorder-traversal/
    // Idea: l-rt-r

    // -> Root level is 0
    // -> Level l can container at most 2^l nodes
    // -> Height is the number of levels that tree has
    // -> Max nodes in tree is 2^h-1
    // -> In BT of n nodes minimum possible height or minimum possible levels is log(n+1) and max height is n.

    // -> Full BT: Each node has 0 or 2 children
    // -> Complete BT: All the node has 2 children and last level has filled from left
    // -> Perfect BT: All the nodes have 2 children and all the leaves are at same level.
    // -> Balanced BT: A tree with height log(n).
    //		-> AVL: Maintains balance by making sure diff of the height of left and right tree is at most 1.
    //		-> RB: Maintains the balance by making sure there are same number of black nodes from root to every leaf and there are no adjacent red nodes.
    // -> Degenerate(pathological) Tree: Every node has single child. It is kind of linked list.
    // -> Traversals:
    //		-> Inorder - L-Rt-R
    // 		-> Preorder - Rt-L-R
    // 		-> Postorder - L-R-Rt
    // 		-> Breath first order(level order) -
    //
    //	 		1
    //		  /	  \
    //		3		4
    //	  /	  \
    //	2		6
    //		  /
    //		5

    // Recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null)
            return;

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    // Idea: Use stack to replace recursion. Store all the elements in stack until left becomes null.
    // Once left become null, exploration of left is complete. Take root from stack and add it to list and move curr to right of root.
    // Time: O(n)
    // space: O(n)
    public List<Integer> inorderIterative(TreeNode root) {
		if(root == null)
			return new ArrayList<>();

        List<Integer> inorder = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                curr = stack.pop();
                inorder.add(curr.val);
                curr = curr.right;
            }
        }

        return inorder;
	}

    // Idea: While going top down, build a link between from current predecessor right most element to current.
    // When current left is becomes null, it uses this link to go up again.
    // Once it goes up, it finds the precessor right most again. But this time precessor right most will be current.
    // In this case, reset predecessor right link to null and exploration of current is complete, move to current.right.
	// Time: O(n)
    // space: O(1)
    public List<Integer> morrisInorder(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
		TreeNode curr = root;
		while(curr != null) {
			if(curr.left == null) {
                inorder.add(curr.val);
				curr = curr.right;
			}else {
				TreeNode prev = curr.left;
				while(prev.right != null && prev.right != curr) {
					prev = prev.right;
				}
				if(prev.right == null) {
					prev.right = curr;
					curr = curr.left;
				}else {
					prev.right = null;
					inorder.add(curr.val);
					curr = curr.right;
				}
			}
		}

        return inorder;
	}
}
