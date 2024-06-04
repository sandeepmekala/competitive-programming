package com.algos.company.google;

import java.util.*;

public class Bfs_PowerPropagationInLatticeGrid {
    private static final int[] DIRS = {-1, 0, 1, 0, -1}; // Directions for navigating up, down, left, right

    // Problem: https://leetcode.com/discuss/interview-question/5063427/google-onsite-round-2
    public static void propagatePower(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Enqueue all torch nodes with their initial power level
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 16) {
                    queue.offer(new int[]{r, c, 16});
                }
            }
        }

        // BFS to propagate power
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int r = node[0], c = node[1], power = node[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + DIRS[i];
                int nc = c + DIRS[i + 1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] < power - 1) {
                    grid[nr][nc] = power - 1;
                    queue.offer(new int[]{nr, nc, power - 1});
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
            {16, 0, 0, 16},
            {0, 0, 0, 0},
            {0, 16, 0, 0},
            {0, 0, 0, 0}
        };

        propagatePower(grid);

        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }
}

