package edu.algos.li15_tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.algos.li00_model.TreeNode;

public class L94_BinaryTreeInorderTraversal {
    
    public static void main(String[] args) {
        L94_BinaryTreeInorderTraversal obj = new L94_BinaryTreeInorderTraversal();
        
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
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root != null){
            inorderTraversal(root.left, list);
            list.add(root.val);
            inorderTraversal(root.right, list);
        }
    }

    // Idea: Use stack to replace recursion. Store all the elements in stack until left becomes null.
    // Once left become null, exploration of left complete. Take root from stack and add it to list and move current to right of root.
    public List<Integer> inorderIterative(TreeNode root) {
		if(root == null) {
			return new ArrayList<>();
		}
		
        List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }

        return list;
	}
	
    // Idea: While going top down, build a link between from current predecessor right most element to current.
    // When current left is becomes null, it uses this link to go up again.
    // Once it goes up it find the precessor right most again. But this time precessor right most will be current.
    // In this case, reset predecessor right link to null and exploration of current is complete, move to current.right.
	public List<Integer> morrisInorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
		TreeNode current = root;
		while(current != null) {
			if(current.left == null) {
                list.add(current.val);
				current = current.right;
			}else {
				TreeNode predcescor = current.left;
				while(predcescor.right != null && predcescor.right != current) { 
					predcescor = predcescor.right;
				}
				if(predcescor.right == null) {
					predcescor.right = current;
					current = current.left;
				}else {
					predcescor.right = null;
					list.add(current.val);
					current = current.right;
				}
			}
		}

        return list;
	}
}
