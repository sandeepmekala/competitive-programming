package li14_backtracking;

import java.util.ArrayList;
import java.util.List;

public class L679_24Game {
    public static void main(String[] args) {
        L679_24Game obj = new L679_24Game();
        System.out.println(obj.judgePoint24(new int[]{4, 1, 8, 7}));
    }

    // Problem: https://leetcode.com/problems/24-game/
    // Idea: Backtracking: Try all possible operations on 2 numbers and then on the result with other 2 numbers.
    // Time: O((4*4*4)^4)
    private final char[] ops = {'+', '-', '*', '/'};

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int num : cards) {
            nums.add((double) num);
        }
        return dfs(nums);
    }

    private boolean dfs(List<Double> nums) {
        int n = nums.size();
        if (n == 1)
            return Math.abs(nums.get(0) - 24) < 1e-6;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j) {
                    List<Double> nxt = new ArrayList<>();
                    for (int k = 0; k < n; ++k) {
                        if (k != i && k != j) {
                            nxt.add(nums.get(k));
                        }
                    }
                    for (char op : ops) {
                        switch (op) {
                            case '/' -> {
                                if (nums.get(j) == 0)
                                    continue;

                                nxt.add(nums.get(i) / nums.get(j));
                            }
                            case '*' -> {
                                nxt.add(nums.get(i) * nums.get(j));
                            }
                            case '+' -> {
                                nxt.add(nums.get(i) + nums.get(j));
                            }
                            case '-' -> {
                                nxt.add(nums.get(i) - nums.get(j));
                            }
                        }
                        if (dfs(nxt))
                            return true;

                        nxt.remove(nxt.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}
