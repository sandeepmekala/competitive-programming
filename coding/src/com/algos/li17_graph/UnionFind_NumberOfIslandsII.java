package  com.algos.li17_graph;

import java.util.ArrayList;
import java.util.List;

public class UnionFind_NumberOfIslandsII {
    private UnionFind_G01_UnionFind uf = new UnionFind_G01_UnionFind();
    public static void main (String[] args) {
        int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
            {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };

        UnionFind_NumberOfIslandsII obj = new UnionFind_NumberOfIslandsII();
        List<Integer> ans = obj.numOfIslands(n, m, operators);

        int sz = ans.size();
        for (int i = 0; i < sz; i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("");
    }

    // Problem: https://leetcode.com/problems/number-of-islands-ii/
    // https://www.lintcode.com/problem/434/
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
                int nrow = row + dr[ind];
                int ncol = col + dc[ind];
                if (isSafe(nrow, ncol, m, n)) {
                    if (visited[nrow][ncol] == 1) {     // check if it is island
                        int nodeNo = row * n + col;
                        int adjNodeNo = nrow * n + ncol;
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

    private boolean isSafe(int nrow, int ncol, int m, int n) {
        return nrow >= 0 && nrow < m && ncol >= 0 && ncol < n;
    }
}
