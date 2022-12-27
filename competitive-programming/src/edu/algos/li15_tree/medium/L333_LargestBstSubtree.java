package edu.algos.li15_tree.medium;

import javax.jws.Oneway;

import edu.algos.li00_model.TreeNode;


public class L333_LargestBstSubtree {
    
    public static void main(String[] args) {
        L333_LargestBstSubtree obj = new L333_LargestBstSubtree();

        		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);

        System.out.println(obj.maxSizeBst(root));
    }

    // Problem: https://leetcode.com/problems/largest-bst-subtree/
    // Idea: Use a data structure int[]{isBst, size, min, max } 
	public int[] maxSizeBst(TreeNode root) {
		if(root == null) {
			return new int[] {1, 0, 0, 0};
		}else if(root.left == null && root.right == null) {
			return new int[] {1, 1, root.val, root.val};
		}
		
		int[] left = maxSizeBst(root.left);
		int[] right = maxSizeBst(root.right);
		
		if(root.left == null && root.right != null) {
			if(root.val < right[2]) {
				return new int[] {1, right[1]+1, root.val, right[3]};
			}else {
				return new int[] {1, right[1], 0, 0};
			}
		}else if(root.left != null && root.right == null) {
			if(root.val > left[3]) {
				return new int[] {1, left[1]+1, left[2], root.val};	
			}else {
				return new int[] {1, left[1], 0, 0};
			}
		}else {
			if(left[0] == 1 && right[0] == 1) {
				if(left[3]<root.val && root.val<right[2]) {
					return new int[] {1, left[1]+right[1]+1, left[2], right[3]};
				}else {
					return new int[] {1, Math.max(left[1], right[1]), 0, 0};
				}
			}else if(left[0] == 1 && right[0] == 0) {
				return new int[] {0, left[1], 0, 0};
			}else if(left[0] == 0 && right[0] == 1) {
				return new int[] {0, right[1], 0, 0};
			}else {
				return new int[] {0, Math.max(left[1], right[1]), 0, 0};
			}
		}	
	}
}
