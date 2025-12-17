import java.util.HashSet;
import java.util.Set;

public class UnionFind_L827_MakingALargeIsland {
    private UnionFind_UnionFind uf = new UnionFind_UnionFind();
    public static void main (String[] args) {
        int[][] grid = {
            {1, 1, 0, 1, 1, 0}, {1, 1, 0, 1, 1, 0},
            {1, 1, 0, 1, 1, 0}, {0, 0, 1, 0, 0, 0},
            {0, 0, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 0}
        };

        UnionFind_L827_MakingALargeIsland obj = new UnionFind_L827_MakingALargeIsland();
        int ans = obj.largestIsland(grid);
        System.out.println("The largest group of connected 1s is of size: " + ans);
    }

    public int largestIsland(int grid[][]) {
        int n = grid.length;
        uf.makeSet(n*n);
        // step - 1
        for (int row = 0; row < n ; row++) {
            for (int col = 0; col < n ; col++) {
                if (grid[row][col] == 0)
                    continue;

                int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
                for (int[] dir : dirs) {
                    int nrow = row + dir[0];
                    int ncol = col + dir[1];
                    if (isSafe(nrow, ncol, n) && grid[nrow][ncol] == 1) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = nrow * n + ncol;
                        uf.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }
        // step 2
        int max = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1)
                    continue;

                Set<Integer> components = new HashSet<>();
                int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
                for (int[] dir : dirs) {
                    int nrow = row + dir[0];
                    int ncol = col + dir[1];
                    if (isSafe(nrow, ncol, n) &&  (grid[nrow][ncol] == 1)) {
                        int adjNodeNo = nrow * n + ncol;
                        components.add(uf.find(adjNodeNo));
                    }
                }
                int sizeTotal = 0;
                for (Integer parent : components) {
                    sizeTotal += uf.getSize(parent);
                }
                max = Math.max(max, sizeTotal + 1);
            }
        }
        for (int cellNo = 0; cellNo < n * n; cellNo++) {    // incase no 0's in array
            int parent = uf.find(cellNo);
            max = Math.max(max, uf.getSize(parent));
        }
        return max;
    }

    private boolean isSafe(int newr, int newc, int n) {
        return newr >= 0 && newr < n && newc >= 0 && newc < n;
    }
}
