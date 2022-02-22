package ds.trees;

import java.util.ArrayList;

public class Trikona {

	private Node root;
	
	public Node buildTrikona(int L){
		
		if(L == 1){
			root = new Node(1);
		}
		
		ArrayList<Node> prevNodes = new ArrayList<Node>();
		ArrayList<Node> nextNodes;
		int nodeValue = 1;
		for(int i=0; i<Math.pow(2, L-1); i++){
			prevNodes.add(new Node(nodeValue++));
		}
		
		int ind;
		for(int j=0; j<L-1; j++){
			ind = 0;
			nextNodes = new ArrayList<Node>();
			while(ind < prevNodes.size()-1){
				int newVal = prevNodes.get(ind).getData()*prevNodes.get(ind+1).getData();
				Node newNode = new Node(newVal);
				newNode.setLeft(prevNodes.get(ind));
				newNode.setRight(prevNodes.get(ind+1));
				nextNodes.add(newNode);
				
				ind = ind + 2;
			}
			prevNodes = nextNodes;
		}
		return prevNodes.get(0);	
	}
	public int trikonaLevelSum(Node root, int N, int X, int Y){
		if(N == 1 && X == 1 && Y == 1){
			return root.getData();
		}
		
		ArrayList<Node> prevNodes = new ArrayList<Node>();
		ArrayList<Node> nextNodes;
		prevNodes.add(root);
		int d=1;
		int sum = 0;
		while(d < N){
			nextNodes = new ArrayList<Node>();
			for(int i=0; i<prevNodes.size(); i++){
				nextNodes.add(prevNodes.get(i).getLeft());
				nextNodes.add(prevNodes.get(i).getRight());
			}
			prevNodes = nextNodes;
			d++;
		}
		
		for(int i=X-1; i<Y; i++){
			sum = sum + prevNodes.get(i).getData();
		}
		return sum;
	}
	public void preorder(Node root){
		if(root != null){	
			System.out.print(root.getData()+" ");
			preorder(root.getLeft());
			preorder(root.getRight());
		}
	}
	
	public static void main(String[] args) {
		Trikona tr = new Trikona();
		
		Node root = tr.buildTrikona(3);
		tr.preorder(root);
		System.out.println();
		System.out.println(tr.trikonaLevelSum(root, 2, 1, 2));
	}
}
