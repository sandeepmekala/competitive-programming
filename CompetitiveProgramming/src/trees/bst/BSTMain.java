package trees.bst;

public class BSTMain {

	public static void main(String[] args) {
		
		BST bst = new BST();
		bst.insert(10);
		bst.insert(2);
		bst.insert(4);
		bst.insert(6);
		bst.insert(5);
		bst.insert(15);
		bst.insert(3);
		
		System.out.println("inorder:");
		bst.inorderPrint();
		
		System.out.println("\nsearch 30:");
		System.out.println(bst.search(30));
		
		/*bst.delete(4);
		System.out.println();
		System.out.println("inorder:");
		bst.inorderPrint();
		System.out.println();
		System.out.println("preorder:");
		bst.preorderPrint();
		System.out.println();
		System.out.println("postorder:");
		bst.postorderPrint();
		System.out.println();
		System.out.println("count:");
		System.out.println(bst.countNodes());
		System.out.println();
		System.out.println("path:");
		System.out.println(bst.pathAsStringToX(30));
		System.out.println();
		System.out.println(bst.pathAsArrayToX(30));
		System.out.println();
		System.out.println("lca "+bst.lca(2, 2));*/
	}

}
