package com.algos.company.google;

public class Dfs_CoastFinder {

    private static final char LAND = 'X';
    private static final char WATER = '.';
    private static final char OCEAN = 'O';
    
    public boolean isCoast(char[][] matrix, int row, int col) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 1: Mark all ocean cells connected to the boundaries
        for (int r = 0; r < rows; r++) {
            if (matrix[r][0] == WATER) {
                dfs(matrix, r, 0);
            }
            if (matrix[r][cols - 1] == WATER) {
                dfs(matrix, r, cols - 1);
            }
        }
        for (int c = 0; c < cols; c++) {
            if (matrix[0][c] == WATER) {
                dfs(matrix, 0, c);
            }
            if (matrix[rows - 1][c] == WATER) {
                dfs(matrix, rows - 1, c);
            }
        }

        // Step 2: Check if the given cell is a coast
        if (matrix[row][col] != LAND) {
            return false;
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && matrix[nr][nc] == OCEAN) {
                return true;
            }
        }

        return false;
    }

    private void dfs(char[][] matrix, int r, int c) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != WATER) {
            return;
        }

        matrix[r][c] = OCEAN;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            dfs(matrix, r + dir[0], c + dir[1]);
        }
    }

    public static void main(String[] args) {
        Dfs_CoastFinder finder = new Dfs_CoastFinder();

        char[][] matrix1 = {
            {'X', 'X', 'X', 'X', 'X', 'X'},
            {'.', '.', '.', 'X', '.', 'X', '.', '.'},
            {'.', '.', '.', 'X', 'X', '.', 'X', '.'}
        };
        System.out.println(finder.isCoast(matrix1, 1, 3));  // Output: true

        char[][] matrix2 = {
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'X', 'X', 'X', '.', 'X', '.'},
            {'X', '.', 'X', 'X', '.', 'X', '.'},
            {'X', 'X', 'X', '.', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X'}
        };
        System.out.println(finder.isCoast(matrix2, 3, 2));  // Output: false
    }
}
