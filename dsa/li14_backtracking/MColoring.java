package li14_backtracking;

import java.util.ArrayList;
import java.util.List;

public class MColoring {
    public static void main(String[] args) {
        MColoring obj = new MColoring();

        List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 4; i++)
			adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(1);
        adj.get(3).add(0);
        adj.get(3).add(1);


        int m=3;
        System.out.println(obj.graphColoring(adj, m));
    }

    public boolean graphColoring(List<List<Integer>> adj, int m){
        int[] colors = new int[adj.size()];
        return coloring(adj, 0, colors, m);
    }

    // Time: O(m^n)
	// Space: O(n)
    private boolean coloring(List<List<Integer>> adj, int node, int[] colors, int m){
        if(node == adj.size())
            return true;

        for(int col=1; col<=m; col++){
            if(isSafe(adj, node, colors, col)){
                colors[node] = col;
                if(coloring(adj, node+1, colors, m))
                    return true;
                colors[node] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(List<List<Integer>> adj, int node, int[] colors, int col) {
        for(int neigh: adj.get(node)){
            if(colors[neigh] == col)
                return false;
        }

        return true;
    }
}
