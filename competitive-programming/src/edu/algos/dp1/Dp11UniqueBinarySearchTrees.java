package edu.algos.dp1;

public class Dp11UniqueBinarySearchTrees {
	public static void main(String[] orgs) {
		Dp11UniqueBinarySearchTrees obj = new Dp11UniqueBinarySearchTrees();
		
		int n=5;
		System.out.println(obj.numTrees(n));
	}

	private int numTrees(int n) {
		int[] mem = new int[n+1];
		mem[0] = 1;
		mem[1] = 1;
		for(int i=2; i<=n; i++) {
			for(int j=0; j<i; j++) {
				System.out.println(i+":"+j);
				mem[i] += mem[j]*mem[i-j-1];	// -1 is to exclude the root
			}
		}
		return mem[n];
	}
}
