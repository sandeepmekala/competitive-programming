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
		bst.inorder();
		
		System.out.println("\nsearch 30:");
		System.out.println(bst.search(30));
		
		bst.delete(4);
		System.out.println("\ninorder:");
		bst.inorder();
		System.out.println("\npreorder:");
		bst.preorder();
		System.out.println("\npostorder:");
		bst.postorder();
		System.out.println("\ncount:");
		System.out.println(bst.count());
		System.out.println("\npath:");
		System.out.println(bst.pathAsString(2));
		System.out.println();
		System.out.println(bst.pathAsArray(30));
		System.out.println("\nlca :");
		System.out.println(bst.lca(2, 3));
		
		System.out.println("\nMin using iteratice approach:");
		System.out.println(bst.min1());
		
		System.out.println("\nMin using recursive approach:");
		System.out.println(bst.min2());
		
		System.out.println("\nMax using iteratice approach:");
		System.out.println(bst.max1());
		
		System.out.println("\nMax using recursive approach:");
		System.out.println(bst.max2());
		
		System.out.println("\nheight:");
		System.out.println(bst.height());
		
		System.out.println("\ninorder:");
		bst.inorder();
		
		System.out.println("\nlevel order:");
		bst.levelOrder();
		
		System.out.println("\nIs BST:");
		System.out.println(bst.isBst());
		
		bst.insert(12);
		bst.insert(20);
		System.out.println("\ninorder:");
		bst.inorder();
		System.out.println("\nlevel order:");
		bst.levelOrder();
		System.out.println("\ndelete: 3");
		bst.delete2(3);
		
		System.out.println("\ninorder:");
		bst.inorder();
		System.out.println("\nlevel order:");
		bst.levelOrder();
		System.out.println("\ndelete: 2");
		bst.delete2(2);
		
		System.out.println("\ninorder:");
		bst.inorder();
		System.out.println("\nlevel order:");
		bst.levelOrder();
		System.out.println("\ndelete: 20");
		bst.delete2(20);
		
		System.out.println("\ninorder:");
		bst.inorder();
		System.out.println("\nlevel order:");
		bst.levelOrder();
		
		System.out.println("\ninorder successor of 5:");
		System.out.println(bst.inoderSuccessor(5).getData());	
		
		bst.insert(7);
		System.out.println("\ninorder successor of 7:");
		System.out.println(bst.inoderSuccessor(7).getData());	
		System.out.println("\ninorder successor of 12:");
		System.out.println(bst.inoderSuccessor(12).getData());
		System.out.println("\ninorder successor of 15:");
		System.out.println(bst.inoderSuccessor(15)!=null?bst.inoderSuccessor(15).getData():null);	
	}

}
