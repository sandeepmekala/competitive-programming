package edu.algos.li15_tree;

import edu.algos.li00_model.TreeNode;

public class CountGoodNodesInBinaryTree {

	public static void main(String[] args) {
		CountGoodNodesInBinaryTree obj = new CountGoodNodesInBinaryTree();
		
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.insert(null, 1, null);
		TreeNode n1 = bt.insert(root, 3, "l");
		TreeNode n2 = bt.insert(root, 4, "r");
		TreeNode n3 = bt.insert(n1, 2, "l");
		TreeNode n4 = bt.insert(n1, 6, "r");
		TreeNode n5 = bt.insert(n4, 5, "l");
		
		System.out.println(obj.goodNodes(root));
		
	}
	
	public int goodNodes(TreeNode root) {
        return 1+goodNodesRec(root.left, root.val)+goodNodesRec(root.right, root.val);
    }
    
    private int goodNodesRec(TreeNode root, int max){
        if(root != null){
            if(root.val >= max){
                return 1+goodNodesRec(root.left, root.val)+goodNodesRec(root.right, root.val);
            }else{
                return goodNodesRec(root.left, max)+goodNodesRec(root.right, max);
            }
        }
        return 0;
    }

}
