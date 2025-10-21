package com.algos.company.google;

import java.util.HashSet;
import java.util.Set;

public class GameLoop_JumpGameWithCycleDetection {

    // Problem: https://leetcode.com/discuss/interview-question/4878831/Google-onsite-question
    public static int findEndPosition(int[] nums, int x, int s) {
        int n = nums.length;
        int currInd = s;
        boolean isOddMove = true;
        Set<Integer> visited = new HashSet<>();

        while (true) {
            if (visited.contains(currInd)) {
                return -1; // Cycle detected
            }
            visited.add(currInd);

            int nextInd = -1;
            if (isOddMove) {
                // Find first index on the left with value A[currentIndex] + 1
                for (int i = currInd - 1; i >= 0; i--) {
                    if (nums[i] == nums[currInd] + 1) {
                        nextInd = i;
                        break;
                    }
                }
            } else {
                // Find first index on the right with value A[currentIndex] + 1
                for (int i = currInd + 1; i < n; i++) {
                    if (nums[i] == nums[currInd] + 1) {
                        nextInd = i;
                        break;
                    }
                }
            }

            if (nextInd == -1) {
                return currInd; // No valid move can be made, return current index
            }

            nums[currInd] += x; // Update the value at currentIndex
            currInd = nextInd; // Move to next index
            isOddMove = !isOddMove; // Toggle the move type
        }
    }

    public static void main(String[] args) {
        int[] A1 = {3, 4, 2, 2, 7};
        int X1 = 4;
        int S1 = 2;
        System.out.println(findEndPosition(A1, X1, S1)); // Output: 1

        int[] A2 = {2, 1};
        int X2 = 2;
        int S2 = 1;
        System.out.println(findEndPosition(A2, X2, S2)); // Output: -1
    }
}
