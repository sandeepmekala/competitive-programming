package algos.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

class HuffmanNode implements Comparable<HuffmanNode> {

	int data;
	char c;

	HuffmanNode left;
	HuffmanNode right;

	@Override
	public int compareTo(HuffmanNode compartingWith) {
		return this.data - compartingWith.data;
	}
}

public class HuffmanCoding {

	// recursive function to print the
	// huffman-code through the tree traversal.
	// Here s is the huffman - code generated.
	public static void printCode(HuffmanNode root, String s) {

		// base case; if the left and right are null
		// then its a leaf node and we print
		// the code s generated by traversing the tree.
		if (root.left == null && root.right == null && root.c != '-') {

			// c is the character in the node
			System.out.println(root.c + ":" + s);

			return;
		}

		// if we go to left then add "0" to the code.
		// if we go to the right add"1" to the code.

		// recursive calls for left and
		// right sub-tree of the generated tree.
		printCode(root.left, s + "0");
		printCode(root.right, s + "1");
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charfreq = { 5, 9, 12, 13, 16, 45 };
		int n = charArray.length;

		HuffmanNode root = buildHuffmanTree(charArray, charfreq);

		// print the codes by traversing the tree
		printCode(root, "");
	}

	// concept: insert the input to min heap so that min retrieval optimal
	// once the tree is build table the last 2 mins and create new internal node by
	// summing their frequency and then insert it back to min heap until only last node left in tree which is 
	// O(nlogn) extract min(logn) is called 2*(n-1) times
	private static HuffmanNode buildHuffmanTree(char[] charArray, int[] charfreq) {
		int n = charArray.length;
		// creating a priority queue q.
		// makes a min-priority queue(min-heap).
		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n);

		for (int i = 0; i < n; i++) {

			// creating a Huffman node object
			// and add it to the priority queue.
			HuffmanNode hn = new HuffmanNode();

			hn.c = charArray[i];
			hn.data = charfreq[i];

			hn.left = null;
			hn.right = null;

			q.add(hn);
		}

		// create a root node
		HuffmanNode root = null;

		// Here we will extract the two minimum value
		// from the heap each time until
		// its size reduces to 1, extract until
		// all the nodes are extracted.
		while (q.size() > 1) {

			// first min
			HuffmanNode x = q.poll();

			// second min
			HuffmanNode y = q.poll();

			// new node f which is equal
			HuffmanNode f = new HuffmanNode();

			// to the sum of the frequency of the two nodes
			// assigning values to the f node.
			f.data = x.data + y.data;
			f.c = '-';

			// first extracted node as left child.
			f.left = x;

			// second extracted node as the right child.
			f.right = y;

			// marking the f node as the root node.
			root = f;

			q.add(f);
		}
		return root;
	}
}