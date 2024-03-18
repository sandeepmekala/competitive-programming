package com.algos.li01_array.revised;

import java.util.ArrayList;
import java.util.List;

public class L118_PascalsTriangle {

    public static void main(String[] args) {
        L118_PascalsTriangle obj = new L118_PascalsTriangle();
        System.out.println(obj.generate(5));
    }

    /*
     * Problem: https://leetcode.com/problems/pascals-triangle/
     * Idea: Track the last row list in a list variable
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> lastRow = null, curRow = null;
        for (int i = 0; i < numRows; i++) {
            curRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curRow.add(1);
                } else {
                    curRow.add(lastRow.get(j - 1) + lastRow.get(j));
                }
            }
            result.add(curRow);
            lastRow = curRow;

        }
        return result;
    }
}
