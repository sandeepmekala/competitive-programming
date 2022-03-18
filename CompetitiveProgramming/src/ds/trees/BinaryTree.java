package ds.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

import ds.stacks.ReverseStringUsingStack;

public class BinaryTree {
	private Node root;	
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
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
		//		-> RB: maintains the balance by making sure there are same number of black nodes from root to every leaf and there are not adjacent red nodes
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
		Node root = bt.insert(null, 1, null);
		Node n1 = bt.insert(root, 3, "l");
		Node n2 = bt.insert(root, 4, "r");
		Node n3 = bt.insert(n1, 2, "l");
		Node n4 = bt.insert(n1, 6, "r");
		Node n5 = bt.insert(n4, 5, "l");
		
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
		System.out.println(sameTree(root, root));
		
		System.out.println("size:");
		System.out.println(size(root));
		
		System.out.println("height:");
		System.out.println(height(root));
		
		System.out.println("path:");
		ArrayList<Integer> path = new ArrayList<Integer>();
		bt.path(root, 5, path);
		System.out.println(path);
		
		System.out.println("path sum: 8");
		ArrayList<Integer> path2 = new ArrayList<Integer>();
		bt.pathSum(root, 8, path2);
		System.out.println(path2);
		
		System.out.println("lca(4 2):"+lca(root,4,2).data);
		
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
		levelorderInBottomUp(root);
		
		System.out.println("\nspiralorder:");
		spiralorder(root);
	}

	public Node insert(Node root, int data, String side){
		Node node = new Node(data);
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
	
	public void preorder(Node root){		// rt-l-r
		if(root != null){	
			System.out.print(root.getData()+" ");
			preorder(root.getLeft());
			preorder(root.getRight());
		}
	}
	
	public void postorder(Node root){		// l-r-rt
		if(root != null){	
			preorder(root.getLeft());
			preorder(root.getRight());
			System.out.print(root.getData()+" ");
		}
	}
	
	public void inorder(Node root){			// l-rt-r
		if(root != null){	
			preorder(root.getLeft());
			System.out.print(root.getData()+" ");
			preorder(root.getRight());
		}
	}

	// use 2 queues if we want to print level by level
	public void levelorder(Node root) {
		if(root == null) {
			return;
		}
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			System.out.print(current.data+" ");
			if(current.left != null) {
				queue.add(current.left);
			}
			if(current.right != null) {
				queue.add(current.right);
			}
		}
	}
	
	// use queue and a stack
	// insert right first into queue so that it gets processed first and inserted into stack
	public static void levelorderInBottomUp(Node root) {
		if(root == null) {
			return;
		}
		
		Queue<Node> queue = new ArrayDeque<Node>();
		Stack<Node> stack = new Stack<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			stack.push(current);
			if(current.right != null) queue.add(current.right);
			if(current.left != null) queue.add(current.left);
		}
		
		while(!stack.isEmpty()) {
			Node current = stack.pop();
			System.out.print(current.data+" ");
		}
	}
	
	public static void spiralorder(Node root) {
		if(root == null) {
			return;
		}
		
		Stack<Node> stack1 = new Stack<Node>(); //rl
		Stack<Node> stack2 = new Stack<Node>(); //lr 
		stack1.push(root);
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				Node current = stack1.pop();
				System.out.print(current.data+" ");
				if(current.left != null) {
					stack2.push(current.left);
				}
				if(current.right != null) {
					stack2.push(current.right);
				}
			}
			while(!stack2.isEmpty()) {
				Node current = stack2.pop();
				System.out.print(current.data+" ");
				if(current.right != null) {
					stack1.push(current.right);
				}
				if(current.left != null) {
					stack1.push(current.left);
				}
			}
		}
	}
	
	private static boolean sameTree(Node root1, Node root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		return (root1.data ==  root2.data) && sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);
	}
	
	private static int size(Node root) {
		if(root == null) {
			return 0;
		}
		
		return 1+size(root.left)+size(root.right);
	}
	
	private static int height(Node root) {
		if(root == null) {
			return 0;
		}
		
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public boolean path(Node root, int data, ArrayList<Integer> path){
		if(root == null){
			return false;
		}
		if(data == root.getData()){
			path.add(root.data);
			return true;
		}
		
		if(path(root.left, data, path)) {
			path.add(root.data);
			return true;
		}
		
		if(path(root.right, data, path)) {
			path.add(root.data);
			return true;
		}
		return false;
	}
	
	public boolean pathSum(Node root, int sum, ArrayList<Integer> path) {
		if(root == null) {
			return false;
		}
		
		if(root.data == sum) {
			path.add(root.data);
			return true;
		}
		
		if(pathSum(root.left, sum-root.data, path)) {
			path.add(root.data);
			return true;
		}
		
		if(pathSum(root.right, sum-root.data, path)) {
			path.add(root.data);
			return true;
		}
		return false;
	}
	
	public static Node lca(Node root, int num1, int num2) {
		if(root == null) {
			return null;
		}
		if(root.data == num1 || root.data == num2) {
			return root;
		}
		
		Node left = lca(root.left, num1, num2);
		Node right = lca(root.right, num1, num2);
		if(left != null && right !=  null) {
			return root;
		}else if(left == null) {
			return right;
		}else if(right == null){
			return left;
		}else {
			return null;
		}
	}
	
	public static int[] maxSizeBst(Node root) {
		if(root == null) {
			return new int[] {1, 0, 0, 0};
		}else if(root.left == null && root.right == null) {
			return new int[] {1, 1, root.data, root.data};
		}
		
		int[] left = maxSizeBst(root.left);
		int[] right = maxSizeBst(root.right);
		
		if(root.left == null && root.right != null) {
			if(root.data < right[2]) {
				return new int[] {1, right[1]+1, root.data, right[3]};
			}else {
				return new int[] {1, right[1], 0, 0};
			}
		}else if(root.left != null && root.right == null) {
			if(root.data > left[3]) {
				return new int[] {1, left[1]+1, left[2], root.data};	
			}else {
				return new int[] {1, left[1], 0, 0};
			}
		}else {
			if(left[0] == 1 && right[0] == 1) {
				if(left[3]<root.data && root.data<right[2]) {
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
	
	public static void preorderIterative(Node root) {
		if(root == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node current = stack.pop();
			System.out.print(current.data+" ");
			if(current.right != null) {
				stack.add(current.right);
			}
			if(current.left != null) {
				stack.add(current.left);
			}
		}
	}
	public static void inorderIterative(Node root) {
		if(root == null) {
			return;
		}
		
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		while(true) {
			if(current != null) {
				stack.push(current);
				current = current.left;
			}else {
				if(stack.isEmpty()) {
					break;
				}
				current = stack.pop();
				System.out.print(current.data+" ");
				current = current.right;
			}
		}
	}
	
	public static void morrisInorder(Node root) {
		Node current = root;
		while(current != null) {
			if(current.left == null) {
				System.out.print(current.data+" ");
				current = current.right;
			}else {
				Node predcescor = current.left;
				while(predcescor.right != null && predcescor.right != current) { 
					predcescor = predcescor.right;
				}
				if(predcescor.right == null) {
					predcescor.right = current;
					current = current.left;
				}else {
					predcescor.right = null;
					System.out.print(current.data+" ");
					current = current.right;
				}
			}
		}
	}
	
	public static void postorderIterativeTwoStacks(Node root) {
		if(root == null) {
			return;
		}
		
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		
		stack1.push(root);
		while(!stack1.isEmpty()) {
			Node current = stack1.pop();
			stack2.push(current);
			if(current.left != null) stack1.push(current.left);
			if(current.right != null) stack1.push(current.right);
		}
		
		while(!stack2.isEmpty()) {
			Node current = stack2.pop();
			System.out.print(current.data+" ");
		}
	}
	public static void postorderIterativeOneStack(Node root) {
		if(root == null) {
			return;
		}
		
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		while(!stack.isEmpty() || current != null) {
			if(current != null) {
				stack.push(current);
				current = current.left;
			}
			if(current == null) {
				Node right = stack.peek().right;
				if(right == null || right == stack.peek().right) {
					System.out.print(stack.pop().data+" ");
				}else {
					current = right;
				}
				
			}
		}
	}
}
