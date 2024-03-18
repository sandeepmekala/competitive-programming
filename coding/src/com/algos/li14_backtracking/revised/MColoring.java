package  com.algos.li14_backtracking.revised;

import java.util.ArrayList;
import java.util.HashMap;

import  com.algos.li30_model.GraphAdjLst;

public class MColoring {
    public static void main(String[] args) {
        MColoring obj = new MColoring();

        GraphAdjLst g = new GraphAdjLst();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
		g.addEdge(2, 0);
        g.addEdge(2, 1);
		g.addEdge(3, 0);
        g.addEdge(3, 1);

        int m=3;
        System.out.println(obj.graphColoring(g.adj, m));
    }

    public boolean graphColoring(HashMap<Integer, ArrayList<Integer>> adj, int m){
        int[] colors = new int[adj.size()];
        return coloring(adj, 0, colors, m);
    }

    // Time: O(m^n)
	// Space: O(n)
    private boolean coloring(HashMap<Integer, ArrayList<Integer>> adj, int node, int[] colors, int m){
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

    private boolean isSafe(HashMap<Integer, ArrayList<Integer>> adj, int node, int[] colors, int col) {
        for(int neigh: adj.get(node)){
            if(colors[neigh] == col) 
                return false;
        }
        return true;
    }
}
