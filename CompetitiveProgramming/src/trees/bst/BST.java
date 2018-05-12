package trees.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BST {

	private Node root;

	public void insert(int data){
		root = insert(root, data);
	}
	public boolean search(int data){
		return search(root, data);
	}
	public void delete(int data){
		delete(root, data);
	}
	public void delete2(int data){
		delete2(root, data);
	}
	public int count(){
		return count(root);
	}
	public int min2(){
		return min2(root);
	}
	public int max2(){
		return max2(root);
	}
	public int height(){
		return height(root);
	}
	public boolean isBst(){
		int max_int = 500000000;
		int min_int = -500000000;
		return isBst(root, min_int, max_int);
	}
	public String pathAsString(int data){
		return pathAsString(root, data);
	}
	public ArrayList<String> pathAsArray(int data){
		return pathAsArray(root, data);
	}
	public String lca(int a, int b){
		return lca(root, a, b);
	}
	public void levelOrder(){
		if(root == null){
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node node = queue.remove();
			System.out.print(node.getData()+" ");
			if(node.getLeft() != null)
				queue.add(node.getLeft());
			if(node.getRight() != null)
				queue.add(node.getRight());
		}
	}
	public void preorder(){
		preorder(root);		
	}
	public void postorder(){
		postoder(root);		
	}
	public void inorder(){
		inorder(root);		
	}
	
	private Node insert(Node  root, int data){
		if(root == null){
			root  = new Node(data);
		}else{
			if(data <= root.getData()){
				root.setLeft(insert(root.getLeft(), data));
			}else if(data > root.getData()){
				root.setRight(insert(root.getRight(), data));
			}
		}
		
		return root;
	}
	private boolean search(Node  root, int data){
		
		if(root == null){
			return false;
		}else{
			if(data < root.getData()){
				return search(root.getLeft(), data);
			}else if(data > root.getData()){
				return search(root.getRight(), data);
			}else{
				return true;
			}
		}		
	}
	private Node searchNode(Node root, int data){
		
		if(root == null){
			return root;
		}else{
			if(data < root.getData()){
				return searchNode(root.getLeft(), data);
			}else if(data > root.getData()){
				return searchNode(root.getRight(), data);
			}else{
				return root;
			}
		}		
	}
	private Node delete(Node root, int data){
		if(root == null){
			System.out.println("Didn't find the node");
		}else{
			if(data < root.getData()){
				root.setLeft(delete(root.getLeft(), data));
			}else if(data > root.getData()){
				root.setRight(delete(root.getRight(), data));
			}else{
				if(root.getLeft() == null && root.getRight() == null){
					return null;
				}else if(root.getLeft() == null){
					return root.getRight();
				}else if(root.getRight() == null){
					return root.getLeft();
				}else if(root.getRight() != null){
					Node preTemp = root.getRight();
					Node temp = root.getRight();

					while(temp.getLeft() != null){
						temp = temp.getLeft();
					}
					temp.setLeft(root.getLeft());
					return preTemp;
				}
			}
		}
		return root;
	}
	private Node delete2(Node root, int data){
		if(root == null){
			return root;
		}
		if(data < root.getData()){
			root.setLeft(delete2(root.getLeft(), data));
		}else if(data > root.getData()){
			root.setRight(delete2(root.getRight(), data));
		}else{
			if(root.getLeft() == null && root.getRight() == null){
				root = null;
			}else if(root.getLeft() == null){
				root = root.getRight();
			}else if(root.getRight() == null){
				root = root.getLeft();
			}else{
				Node temp = root.getRight();
				while(temp.getLeft() != null ){
					temp = temp.getLeft();
				}
				root.setData(temp.getData());
				root = delete2(root.getRight(), temp.getData());
			}
		}
		return root;
	}
	private int count(Node root){
		int cnt = 1;
		if(root == null){
			return 0;
		}else{
			cnt += count(root.getLeft());
			cnt += count(root.getRight());
		}
		return cnt;
	}
	public int min1(){
		Node node = root;
		if(node == null){
			System.out.println("Tree is empty");
			return -1;
		}
		while(node.getLeft() != null){
			node = node.getLeft();
		}
		return node.getData();
	}
	public int max1(){
		Node node = root;
		if(node == null){
			System.out.println("Tree is empty");
			return -1;
		}
		while(node.getRight() != null){
			node = node.getRight();
		}
		return node.getData();
	}
	private int min2(Node root){
		if(root == null){
			System.out.println("Tree is empty");
			return -1;
		}
		if(root.getLeft() == null){
			return root.getData();
		}
		
		return min2(root.getLeft());
	}
	private int max2(Node root){
		if(root == null){
			System.out.println("Tree is empty");
			return -1;
		}
		if(root.getRight() == null){
			return root.getData();
		}
		
		return max2(root.getRight());
	}
	private Node findMin(Node root){
		if(root == null){
			return root;
		}
		Node temp = root;
		while(temp.getLeft() != null){
			temp = temp.getLeft();
		}
		return temp;
	}
	private int height(Node root){
		if(root == null){
			return -1;
		}		
		return Math.max(height(root.getLeft()), height(root.getRight()))+1;
	}
	private boolean isBst(Node root, int min_int, int max_int){
		if(root == null){
			return true;
		}
		if((root.getData() >= min_int && root.getData() < max_int) 
				&& isBst(root.getLeft(),min_int, root.getData())
				&& isBst(root.getRight(), root.getData(), max_int)){
			return true;
		}
		return false;
	}
	public Node inoderSuccessor(int data){
		if(root == null){
			return root;
		}
		Node current = searchNode(root, data);
		if(current == null){
			return null;
		}
		if(current.getRight() != null){
			return findMin(current.getRight());
		}else{
			Node successor = null;
			Node ancestor = root;
			while(ancestor.getData() != current.getData()){
				if(current.getData() < ancestor.getData()){
					successor = ancestor;
					ancestor = ancestor.getLeft();
				}else{
					ancestor = ancestor.getRight();
				}
			}
			return successor;
		}
		
	}
	private String pathAsString(Node root, int data){
		if(root == null){
			return "Not Found";
		}
		
		String path = root.getData()+"->";
		if(data < root.getData()){
			path += pathAsString(root.getLeft(), data);
		}else if(data > root.getData()){
			path += pathAsString(root.getRight(), data);
		}else{
			return root.getData()+"";
		}
		return path;
	}
	private ArrayList<String> pathAsArray(Node root, int data){
		if(root == null){
			return new ArrayList<String>(Arrays.asList("Not Found"));
		}
		
		ArrayList<String> path = new ArrayList<String>();
		path.add(root.getData()+"");
		if(data < root.getData()){
			path.addAll(pathAsArray(root.getLeft(), data));
		}else if(data > root.getData()){
			path.addAll(pathAsArray(root.getRight(), data));
		}else{
			return new ArrayList<String>(Arrays.asList(root.getData()+""));
		}
		return path;
	}
	private String lca(Node root, int a, int b){
		if(root == null)
			return "Not Found";
		
		if(!search(a) || !search(b))
			return "Not Found";
		
		if(a < root.getData() && b < root.getData()){
			return lca(root.getLeft(), a, b);
		}else if(a > root.getData() && b > root.getData()){
			return lca(root.getRight(), a, b);
		}else{
			return root.getData()+"";
		}		
	}
	
	private void preorder(Node root){
		if(root != null){	
			System.out.print(root.getData()+" ");
			preorder(root.getLeft());
			preorder(root.getRight());
		}
	}
	private void postoder(Node root){
		if(root != null){	
			postoder(root.getLeft());
			postoder(root.getRight());
			System.out.print(root.getData()+" ");
		}
	}
	private void inorder(Node root){
		if(root != null){	
			inorder(root.getLeft());
			System.out.print(root.getData()+" ");
			inorder(root.getRight());
		}
	}
}
