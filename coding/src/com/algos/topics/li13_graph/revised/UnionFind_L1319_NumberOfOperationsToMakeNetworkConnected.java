package  com.algos.topics.li13_graph.revised;

public class UnionFind_L1319_NumberOfOperationsToMakeNetworkConnected {

    private UnionFind_UnionFind uf = new UnionFind_UnionFind();
    public static void main(String[] args) {
        UnionFind_L1319_NumberOfOperationsToMakeNetworkConnected obj = new UnionFind_L1319_NumberOfOperationsToMakeNetworkConnected();

        int n=5;
        //int[][] connections = new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}};
        int[][] connections = new int[][]{{0,1},{0,2},{3,4},{2,3}};
        System.out.println(obj.makeConnected(n, connections));
    }

    // Problem: https://leetcode.com/problems/number-of-operations-to-make-network-connected/
    // Idea: Solution is number of components-duplicate edges.
    // Build DSU and count extra edges
    public int makeConnected(int n, int[][] connections) {
        uf.makeSet(n);
        int extraCons = 0;
        for(int[] conn: connections){
            int u = conn[0], v = conn[1];
            if(uf.find(u) == uf.find(v)){
                extraCons++;
            }else{
                uf.unionByRank(u, v);
            }
        }

        int compCnt = 0;
        for(int i=0; i<n; i++){
            if(uf.find(i) == i){
                compCnt++;
            }
        }

        int ans = compCnt-1;
        if(extraCons >= ans) return ans;
        return -1;
    }

}
