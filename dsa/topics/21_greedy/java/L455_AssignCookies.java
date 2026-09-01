import java.util.Arrays;

public class L455_AssignCookies {
    public static void main(String[] args) {
        L455_AssignCookies obj = new L455_AssignCookies();
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[]{1, 1};
        System.out.println(obj.findContentChildren(g, s));
    }

    // Problem: https://leetcode.com/problems/assign-cookies/
    // Idea: Greedy: Assign the cookie to the child who has least greed factor and can be satisfied with the cookie.
    // Time: O(nlogn)
    public int findContentChildren(int[] g, int[] s) {
        int m=g.length, n=s.length;
        int l=0, r=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(l<m && r<n){
            if(g[l] <= s[r])
                l++;
            r++;
        }

        return l;
    }
}
