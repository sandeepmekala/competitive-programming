package edu.algos.li19_backtracking;

import java.util.ArrayList;
import java.util.HashMap;

import edu.algos.li00_model.GraphAdjLst;

public class G03_MColoring {
    public static void main(String[] args) {
        G03_MColoring obj = new G03_MColoring();

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
        return graphColoring(adj, 0, colors, m);
    }

    private boolean graphColoring(HashMap<Integer, ArrayList<Integer>> adj, int node, int[] colors, int m){
        if(node == adj.size()) return true;

        for(int i=1; i<=m; i++){
            if(isSafe(adj, node, colors, i)){
                colors[node] = i;
                if(graphColoring(adj, node+1, colors, m))
                    return true;
                colors[node] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(HashMap<Integer, ArrayList<Integer>> adj, int node, int[] colors, int col) {
        for(int neigh: adj.get(node)){
            if(colors[neigh] == col) return false;
        }
        return true;
    }
}
