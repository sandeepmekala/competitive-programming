
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Dfs_G01_LargestConnectedComponents {

	public static void main(String[] args) {
		Dfs_G01_LargestConnectedComponents obj = new Dfs_G01_LargestConnectedComponents();

		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 9; i++)
			adj.add(new ArrayList<>());

		adj.get(1).add(2);
		adj.get(2).add(1);
		adj.get(4).add(6);
		adj.get(6).add(4);
		adj.get(5).add(6);
		adj.get(6).add(5);
		adj.get(7).add(6);
		adj.get(6).add(7);
		adj.get(8).add(6);
		adj.get(6).add(8);
		adj.get(3).add(3);

		System.out.println(obj.largestConnectedComponents(adj));
	}

	private int largestConnectedComponents(List<List<Integer>> adj) {
		int max = 0;
		HashSet<Integer> visited = new HashSet<>();
		for(int src=0; src<adj.size(); src++) {
			max = Math.max(max, dfs(adj, src, visited));
		}
		return max;
	}

	private int dfs(List<List<Integer>> adj, int src, HashSet<Integer> visited) {
		if(visited.contains(src))
			return 0;

		visited.add(src);
		int count = 1;
		for(int child: adj.get(src)) {
			count += dfs(adj, child, visited);
		}
		return count;
	}

}
