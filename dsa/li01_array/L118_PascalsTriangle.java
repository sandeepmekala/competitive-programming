package li01_array;

import java.util.ArrayList;
import java.util.List;

public class L118_PascalsTriangle {

    public static void main(String[] args) {
        L118_PascalsTriangle obj = new L118_PascalsTriangle();
        System.out.println(obj.generate(5));
    }

    // Problem: https://leetcode.com/problems/pascals-triangle/
    // Idea: Track the prev row list in a list variable
    // Time: O(n^2), Space: O(n^2)
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(getRow(i));              // 0-based index
        }
        return result;
    }

    public List<Integer> getRow(int row) {      // 0-based index
        List<Integer> result = new ArrayList<>();
        long ans = 1;
        result.add(1);                          // col = 0
        for(int col=1; col<=row; col++){        // 0-based index
            ans *= (row+1-col);
            ans /= col;
            result.add((int)(ans));
        }

        return result;
    }
}
