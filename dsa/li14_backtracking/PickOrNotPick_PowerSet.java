package li14_backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickOrNotPick_PowerSet {
    static void solve(int i, String s, String f) {
        if (i == s.length()) {
            System.out.print(f + " ");
            return;
        }
        // picking
        // f = f + s.charAt(i);
        solve(i + 1, s, f + s.charAt(i));
        // poping out while backtracking
        // f.pop_back();
        solve(i + 1, s, f);
    }

    static List<String> AllPossibleStrings(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        for (int num = 0; num < (1 << n); num++) {
            String sub = "";
            for (int i = 0; i < n; i++) {
                //check if the ith bit is set or not
                if ((num & (1 << i))!=0) {
                    sub += s.charAt(i);
                }
            }

            ans.add(sub);
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String args[]) {
        String s = "abc";
        String f = "";
        solve(0, s, f);
        System.out.println();

        // Iterative approach
        List<String> ans = AllPossibleStrings(s);
        System.out.println(ans);
    }
}
