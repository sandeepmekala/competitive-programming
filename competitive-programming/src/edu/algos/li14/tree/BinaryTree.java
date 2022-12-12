package edu.algos.li14.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import edu.algos.li00_model.TreeNode;

public class BinaryTree {
	public TreeNode root;	
	public static void main(String[] args) {
		// -> root level is 0
		// -> level l can container at most 2^l nodes
		// -> height is the number of levels that tree has
		// -> max nodes in tree is 2^h-1
		// -> in BT of n node minimum possible height or minimum possible levels is log(n+1)
		// -> full BT: each node has 0 or 2 children
		// -> complete BT: all the node has 2 children and last level has filled from left
		// -> perfect BT: all the nodes have 2 children and all the leaves are at same level
		// -> Balanced BT: a tree with height lon(n). 
		//		-> AVL: maintains balance by making sure the height of left and right tree is at most 1
		//		-> RB: maintains the balance by making sure there are same number of black nodes from root to every leaf and there are no adjacent red nodes
		// -> degenerate(pathological) tree: every node has single child. It is kind of linked list.
		// -> traversals: inorder, preorder, postorder, breath first order(level order)
		
		//	 		1
		//		  /	  \
		//		3		4
		//	  /	  \		  
		//	2		6
		//		  /
		//		5
		
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.insert(null, 1, null);
		TreeNode n1 = bt.insert(root, 3, "l");
		TreeNode n2 = bt.insert(root, 4, "r");
		TreeNode n3 = bt.insert(n1, 2, "l");
		TreeNode n4 = bt.insert(n1, 6, "r");
		TreeNode n5 = bt.insert(n4, 5, "l");
		
		System.out.println("preorder:");
		bt.preorder(root);
		System.out.println();
		
		System.out.println("inorder:");
		bt.inorder(root);
		System.out.println();
		
		System.out.println("postorder:");
		bt.postorder(root);
		System.out.println();
		
		System.out.println("levelorder:");
		bt.levelorder(root);
		
		System.out.println("\nsame tree?:");
		System.out.println(isSameTree(root, root));
		
		System.out.println("size:");
		System.out.println(size(root));
		
		System.out.println("height:");
		System.out.println(bt.height(root));
		
		System.out.println("path:");
		ArrayList<Integer> path = new ArrayList<Integer>();
		bt.path(root, 5, path);
		System.out.println(path);
		
		System.out.println("path sum: 8");
		ArrayList<Integer> path2 = new ArrayList<Integer>();
		bt.pathSum(root, 8, path2);
		System.out.println(path2);
		
		System.out.println("inorder:");
		bt.inorder(root);
		System.out.println();
		System.out.println("lca(4 2):"+lowestCommonAncestor(root,4,2).val);
		
		System.out.println("size of max bst:"+ maxSizeBst(root)[1]);
		
		System.out.println("preorder iterative:");
		preorderIterative(root);
		
		System.out.println("\ninorder iterative:");
		inorderIterative(root);
		
		System.out.println("\nmorris inorder:");
		morrisInorder(root);
		
		System.out.println("\npostorder iterative:");
		postorderIterativeTwoStacks(root);
		
		System.out.println("\npostorder iterative 1 stack:");
		postorderIterativeOneStack(root);
		
		System.out.println("\nlevelorder bottom up:");
		bt.levelorderInBottomUp(root);
		
		System.out.println("\nzigzagLevelOrder:");
		System.out.println(bt.zigzagLevelOrder(root));
	}

	public TreeNode insert(TreeNode root, int data, String side){
		TreeNode node = new TreeNode(data);
		if(root == null){
			return node;
		}
		if("l".equals(side)){
			root.setLeft(node);
			return node;
		}else if("r".equals(side)){
			root.setRight(node);
			return node;
		}else{
			throw new RuntimeException("Specify the side");
		}
		
	}
	
	public void preorder(TreeNode root){		// rt-l-r
		if(root != null){	
			System.out.print(root.getData()+" ");
			preorder(root.getLeft());
			preorder(root.getRight());
		}
	}
	
	public void postorder(TreeNode root){		// l-r-rt
		if(root != null){	
			preorder(root.getLeft());
			preorder(root.getRight());
			System.out.print(root.getData()+" ");
		}
	}
	
	public void inorder(TreeNode root){			// l-rt-r
		if(root != null){	
			preorder(root.getLeft());
			System.out.print(root.getData()+" ");
			preorder(root.getRight());
		}
	}

	// use 2 queues if we want to print level by level. check Trie ds impl for details.
	public void levelorder(TreeNode root) {
		if(root == null) {
			return;
		}
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode current = queue.poll();
			System.out.print(current.val+" ");
			if(current.left != null) {
				queue.add(current.left);
			}
			if(current.right != null) {
				queue.add(current.right);
			}
		}
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
            
        Queue<TreeNode> queue1 = new ArrayDeque<TreeNode>();
		Queue<TreeNode> queue2 = new ArrayDeque<TreeNode>();
		queue1.add(root);
		while(!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
			while(!queue1.isEmpty()) {
				TreeNode current = queue1.remove();
				level.add(current.val);
                if(current.left != null){
                    queue2.add(current.left);    
                }
                if(current.right != null){
                    queue2.add(current.right);    
                }
			}
            if(!level.isEmpty()){
                result.add(level);    
            }
            
            level = new ArrayList<Integer>();
			while(!queue2.isEmpty()) {
				TreeNode current = queue2.remove();
				level.add(current.val);
                if(current.left != null){
                    queue1.add(current.left);    
                }
				if(current.right != null){
                    queue1.add(current.right);                    
                }
			}
            if(!level.isEmpty()){
                result.add(level);    
            }
		}
        return result;
    }
	
	// use queue and a stack
	// insert right first into queue so that it gets processed first and inserted into stack
	public void levelorderInBottomUp(TreeNode root) {
		if(root == null) {
			return;
		}
		
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode current = queue.poll();
			stack.push(current);
			if(current.right != null) queue.add(current.right);	//	right first
			if(current.left != null) queue.add(current.left);
		}
		
		while(!stack.isEmpty()) {
			TreeNode current = stack.pop();
			System.out.print(current.val+" ");
		}
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
		
		Stack<TreeNode> stack1 = new Stack<TreeNode>(); //rl
		Stack<TreeNode> stack2 = new Stack<TreeNode>(); //lr 
		stack1.push(root);
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
			while(!stack1.isEmpty()) {
				TreeNode current = stack1.pop();
				level.add(current.val);
				if(current.left != null) {
					stack2.push(current.left);
				}
				if(current.right != null) {
					stack2.push(current.right);
				}
			}
            if(!level.isEmpty()){
                result.add(level);    
            }
            
            level = new ArrayList<Integer>();
			while(!stack2.isEmpty()) {
				TreeNode current = stack2.pop();
				level.add(current.val);
				if(current.right != null) {
					stack1.push(current.right);			//right first
				}
				if(current.left != null) {
					stack1.push(current.left);
				}
			}
            if(!level.isEmpty()){
                result.add(level);    
            }
		}
        
        return result;
    }
	
	private static boolean isSameTree(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null) {
			return true;
		}else if(root1 == null){
            return false;
        }else if(root2 == null){
            return false;
        }else{
            return (root1.val ==  root2.val) && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
        }
	}
	
	private static int size(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		return 1+size(root.left)+size(root.right);
	}
	
	public int height(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public boolean path(TreeNode root, int data, ArrayList<Integer> path){
		if(root == null){
			return false;
		}
		if(data == root.getData()){
			path.add(root.val);
			return true;
		}
		
		if(path(root.left, data, path)) {
			path.add(root.val);
			return true;
		}
		
		if(path(root.right, data, path)) {
			path.add(root.val);
			return true;
		}
		return false;
	}
	
	public boolean pathSum(TreeNode root, int sum, ArrayList<Integer> path) {
		if(root == null) {
			return false;
		}
		
		if(root.val == sum) {
			path.add(root.val);
			return true;
		}
		
		if(pathSum(root.left, sum-root.val, path)) {
			path.add(root.val);
			return true;
		}
		
		if(pathSum(root.right, sum-root.val, path)) {
			path.add(root.val);
			return true;
		}
		return false;
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, int num1, int num2) {
		if(root == null) {
			return null;
		}
		if(root.val == num1 || root.val == num2) {
			return root;
		}
		
		TreeNode left = lowestCommonAncestor(root.left, num1, num2);
		TreeNode right = lowestCommonAncestor(root.right, num1, num2);
		if(left != null && right !=  null) {
			return root;
		}else if(left != null) {
			return left;
		}else if(right != null){
			return right;
		}else {
			return null;
		}
	}
	// use a data structure int[]{isBst, height, min, max } 
	public static int[] maxSizeBst(TreeNode root) {
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
	
	// stack instead to compensate for recursion
	public static void preorderIterative(TreeNode root) {
		if(root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode current = stack.pop();
			System.out.print(current.val+" ");
			if(current.right != null) {
				stack.add(current.right);
			}
			if(current.left != null) {
				stack.add(current.left);
			}
		}
	}
	public static void inorderIterative(TreeNode root) {
		if(root == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		while(true) {
			if(current != null) {
				stack.push(current);
				current = current.left;
			}else {
				if(stack.isEmpty()) {
					break;
				}
				current = stack.pop();
				System.out.print(current.val+" ");
				current = current.right;
			}
		}
	}
	
	public static void morrisInorder(TreeNode root) {
		TreeNode current = root;
		while(current != null) {
			if(current.left == null) {
				System.out.print(current.val+" ");
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
					System.out.print(current.val+" ");
					current = current.right;
				}
			}
		}
	}
	
	public static void postorderIterativeTwoStacks(TreeNode root) {
		if(root == null) {
			return;
		}
		
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		
		stack1.push(root);
		while(!stack1.isEmpty()) {
			TreeNode current = stack1.pop();
			stack2.push(current);
			if(current.left != null) stack1.push(current.left);
			if(current.right != null) stack1.push(current.right);
		}
		
		while(!stack2.isEmpty()) {
			TreeNode current = stack2.pop();
			System.out.print(current.val+" ");
		}
	}
	public static void postorderIterativeOneStack(TreeNode root) {
		if(root == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		while(!stack.isEmpty() || current != null) {
			if(current != null) {
				stack.push(current);
				current = current.left;
			}
			if(current == null) {
				TreeNode right = stack.peek().right;
				if(right == null || right == stack.peek().right) {
					System.out.print(stack.pop().val+" ");
				}else {
					current = right;
				}
				
			}
		}
	}
}
