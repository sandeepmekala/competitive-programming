
import java.util.Arrays;

public class Bipartite_L1820_MaximumNumberOfAcceptedInvitations {

    public static void main(String[] args) {
        Bipartite_L1820_MaximumNumberOfAcceptedInvitations obj = new Bipartite_L1820_MaximumNumberOfAcceptedInvitations();
        int[][] grid = {
            {1, 1, 1},
            {1, 0, 1},
            {0, 0, 1}
        };
        System.out.println(obj.maximumInvitations(grid));
    }

    // Problem: https://leetcode.ca/2020-11-23-1820-Maximum-Number-of-Accepted-Invitations/
    // Idea: Hopcroft-Karp algorithm for maximum matching in bipartite graph
    // Time complexity: O(m*n)
    public int maximumInvitations(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        boolean[] vis = new boolean[n];
        int[] match = new int[n];
        Arrays.fill(match, -1);
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            Arrays.fill(vis, false);
            if (find(grid, i, vis, match)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean find(int[][] grid, int i, boolean[] vis, int[] match) {
        int n = grid[0].length;
        for (int j = 0; j < n; ++j) {
            if (grid[i][j] == 1 && !vis[j]) {
                vis[j] = true;
                if (match[j] == -1 || find(grid, match[j], vis, match)) {
                    match[j] = i;
                    return true;
                }
            }
        }
        return false;
    }
}
