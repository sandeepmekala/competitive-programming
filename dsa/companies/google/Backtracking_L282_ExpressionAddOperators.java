import java.util.ArrayList;
import java.util.List;

public class Backtracking_L282_ExpressionAddOperators {

    // Problem: https://leetcode.com/problems/expression-add-operators/description/
    // Idea: Backtracking
    // Time: O(4^n)
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0)
            return result;

        dfs(result, "", num, target, 0, 0, 0);
        return result;
    }

    private void dfs(List<String> result, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval) {
                result.add(path);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break; // Skip numbers with leading zeros
            }
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                dfs(result, path + cur, num, target, i + 1, cur, cur);
            } else {
                dfs(result, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                dfs(result, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                dfs(result, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }

    public static void main(String[] args) {
        Backtracking_L282_ExpressionAddOperators obj = new Backtracking_L282_ExpressionAddOperators();
        String num = "123";
        int target = 6;
        List<String> expressions = obj.addOperators(num, target);
        for (String expression : expressions) {
            System.out.println(expression);
        }
    }
}
