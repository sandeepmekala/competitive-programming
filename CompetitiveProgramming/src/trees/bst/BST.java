package trees.bst;

import java.util.ArrayList;
import java.util.Arrays;

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
	public int countNodes(){
		return count(root);
	}
	public String pathAsStringToX(int data){
		return pathAsStringToX(root, data);
	}
	public ArrayList<String> pathAsArrayToX(int data){
		return pathAsArrayToX(root, data);
	}
	public String lca(int a, int b){
		return lca(root, a, b);
	}
	public void preorderPrint(){
		preorder(root);		
	}
	public void postorderPrint(){
		postoder(root);		
	}
	public void inorderPrint(){
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
	private int count(Node root){
		if(root == null){
			return 0;
		}else{
			int cnt = 1;
			cnt += count(root.getLeft());
			cnt += count(root.getRight());
			return cnt;
		}

	}
	private String pathAsStringToX(Node root, int data){
		if(root == null){
			return "Not Found";
		}
		
		String path = root.getData()+"->";
		if(data < root.getData()){
			path += pathAsStringToX(root.getLeft(), data);
		}else if(data > root.getData()){
			path += pathAsStringToX(root.getRight(), data);
		}else{
			return root.getData()+"";
		}
		return path;
	}
	private ArrayList<String> pathAsArrayToX(Node root, int data){
		if(root == null){
			return new ArrayList<String>(Arrays.asList("Not Found"));
		}
		
		ArrayList<String> path = new ArrayList<String>();
		path.add(root.getData()+"");
		if(data < root.getData()){
			path.addAll(pathAsArrayToX(root.getLeft(), data));
		}else if(data > root.getData()){
			path.addAll(pathAsArrayToX(root.getRight(), data));
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
