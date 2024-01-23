package edu.algos.li20_dp;

public class _Partitions_L99_UniqueBinarySearchTrees {
	public static void main(String[] orgs) {
		_Partitions_L99_UniqueBinarySearchTrees obj = new _Partitions_L99_UniqueBinarySearchTrees();
		
		int n=5;
		System.out.println(obj.numTrees(n));
	}

	public int numTrees(int n) {
		int[] mem = new int[n+1];
		mem[0] = 1;
		mem[1] = 1;
		for(int i=2; i<=n; i++) {
			for(int j=0; j<i; j++) {
				//System.out.println(i+":"+j);
				mem[i] += mem[j]*mem[i-j-1];	// -1 is to exclude the root
			}
		}
		return mem[n];
	}
}
