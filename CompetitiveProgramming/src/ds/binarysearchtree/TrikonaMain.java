package ds.binarysearchtree;

public class TrikonaMain {

	public static void main(String[] args) {
		Trikona tr = new Trikona();
		
		Node root = tr.buildTrikona(3);
		tr.preorder(root);
		System.out.println();
		System.out.println(tr.trikonaLevelSum(root, 2, 1, 2));
	}

}
