package trees.bst;

import java.util.Stack;

public class BinaryTree {
	private Node root;	
	
	public Node insert(Node root, int data, String side){
		if(root == null){
			return new Node(data);
		}
		if("l".equals(side)){
			Node node = new Node(data);
			root.setLeft(node);
			return node;
		}else if("r".equals(side)){
			Node node = new Node(data);
			root.setRight(node);
			return node;
		}else{
			throw new RuntimeException("Specify the root");
		}
		
	}
	public Stack<String> pathToXAsArray(Node root, int data){
		/*if(root == null){
			return new ArrayList<String>(Arrays.asList("Not Found"));
		}
		ArrayList<String> leftPath = new ArrayList<String>(); 
		ArrayList<String> rightPath = new ArrayList<String>(); 
		leftPath.add(root.getData()+"");
		rightPath.add(root.getData()+"");
		if(data == root.getData()){
			return new ArrayList<String>(Arrays.asList(root.getData()+""));
		}
		
		if(!leftPath.contains("Not Found")){
			leftPath.addAll(pathToXAsArray(root.getLeft(), data));
			return leftPath;
		}
		if(!rightPath.contains("Not Found")){
			leftPath.addAll(pathToXAsArray(root.getRight(), data));
			return rightPath;
		}
		
		return new ArrayList<String>(Arrays.asList("Not Found"));*/
		
		if(root != null)
			System.out.println(root.getData()+"");
		if(root == null){
			Stack<String> stack = new Stack<String>();
			stack.add("Not Found");
			return stack;
		}
		if(data == root.getData()){
			Stack<String> stack = new Stack<String>();
			stack.add(root.getData()+"");
			return stack;
		}
		
		Stack<String> leftPath = pathToXAsArray(root.getLeft(), data);
		if(!leftPath.contains("Not Found")){
			leftPath.add(root.getData()+"");
			return leftPath;
		}
		
		Stack<String> rightPath = pathToXAsArray(root.getRight(), data);
		if(!rightPath.contains("Not Found")){
			rightPath.add(root.getData()+"");
			return rightPath;
		}
		
		Stack<String> stack = new Stack<String>();
		stack.add("Not Found");
		return stack;
	}
	public void preorder(Node root){
		if(root != null){	
			System.out.print(root.getData()+" ");
			preorder(root.getLeft());
			preorder(root.getRight());
		}
	}
	public void postoder(Node root){
		if(root != null){	
			preorder(root.getLeft());
			preorder(root.getRight());
			System.out.print(root.getData()+" ");
		}
	}
	public void inorder(Node root){
		if(root != null){	
			preorder(root.getLeft());
			System.out.print(root.getData()+" ");
			preorder(root.getRight());
		}
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	

}
