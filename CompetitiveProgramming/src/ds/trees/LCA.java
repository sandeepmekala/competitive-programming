package ds.trees;

import java.util.ArrayList;

public class LCA {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		/*bst.insert(10);
		bst.insert(2);
		bst.insert(4);
		bst.insert(6);
		bst.insert(5);
		bst.insert(15);
		bst.insert(3);
		
		System.out.println("2, 5 "+lca(bst, 2, 5));
		System.out.println("2, 15 "+lca(bst, 2, 15));
		System.out.println("2, 2 "+lca(bst, 2, 2));
		System.out.println("2, 30 "+lca(bst, 2, 30));*/
		
		bst.insert(1);
		bst.insert(3);
		bst.insert(2);
		bst.insert(4);
		bst.insert(6);
		bst.insert(5);
		
		System.out.println(bst.lca(4, 5));
	}
	private static String lca(BinarySearchTree bst, int a, int b){
	
		if(a == b){
			return a+"";
		}
		
		ArrayList<String> pathToA = bst.pathAsArrayToX(a);
		ArrayList<String> pathToB = bst.pathAsArrayToX(b);
		if(pathToA.contains("Not Found") || pathToB.contains("Not Found"))
			return "Not Found";
		
		if(pathToA.size() >= pathToB.size()){
			pathToA.retainAll(pathToB);
			return pathToA.get(pathToA.size()-1);
		}else{
			pathToB.retainAll(pathToA);
			return pathToB.get(pathToB.size()-1);
		}
		
	} 
}