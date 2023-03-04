package edu.algos.li17_graph.medium;

import java.util.ArrayList;
import java.util.List;

public class _UnionFind_NumberOfIslandsII {
    private _UnionFind_G01_UnionFind uf = new _UnionFind_G01_UnionFind();
    public static void main (String[] args) {
        int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
            {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };

        _UnionFind_NumberOfIslandsII obj = new _UnionFind_NumberOfIslandsII();
        List<Integer> ans = obj.numOfIslands(n, m, operators);

        int sz = ans.size();
        for (int i = 0; i < sz; i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("");
    }

    public List<Integer> numOfIslands(int m, int n, int[][] operators) {
        uf.makeSet(m * n);
        int[][] visited = new int[m][n];
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        int len = operators.length;
        for (int i = 0; i < len ; i++) {
            int row = operators[i][0], col = operators[i][1];
            if (visited[row][col] == 1) {
                ans.add(count);
                continue;
            }
            visited[row][col] = 1;
            count++;
            int dr[] = { -1, 0, 1, 0};
            int dc[] = {0, 1, 0, -1};
            for (int ind = 0; ind < 4; ind++) {
                int adjr = row + dr[ind];
                int adjc = col + dc[ind];
                if (isValid(adjr, adjc, m, n)) {
                    if (visited[adjr][adjc] == 1) {     // check if it is island
                        int nodeNo = row * n + col;
                        int adjNodeNo = adjr * n + adjc;
                        if (uf.find(nodeNo) != uf.find(adjNodeNo)) {
                            count--;
                            uf.unionByRank(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }

    private boolean isValid(int adjr, int adjc, int n, int m) {
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }
}
