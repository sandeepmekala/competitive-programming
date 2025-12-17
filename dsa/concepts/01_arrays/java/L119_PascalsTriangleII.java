package li01_array.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L119_PascalsTriangleII {

	public static void main(String[] args) {
		L119_PascalsTriangleII obj = new L119_PascalsTriangleII();

		System.out.println(obj.getRow(3));
	}

    // Problem: https://leetcode.com/problems/pascals-triangle-ii/
    // Idea: value at index k = nCk. But this can go out of bounds due to multiplication.
    // Time: O(n), Space: O(n)
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
