package li03_slidingwindow.revised;

import java.util.Arrays;

public class L1358_NumberofSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        L1358_NumberofSubstringsContainingAllThreeCharacters obj = new L1358_NumberofSubstringsContainingAllThreeCharacters();

        String s = "abcabc";
        System.out.println(obj.numberOfSubstrings(s));
    }

    // Problem: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
    // idea: Track the last seen index of each character. If all characters are seen atleast once, then the number of substrings ending at that index is min of last seen index of all characters + 1
    // Time: O(n)
    public int numberOfSubstrings(String s) {
        int n = s.length(), r = 0, count = 0;
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen, -1);

        while (r < n) {
            lastSeen[s.charAt(r) - 'a'] = r;

            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1)
                count += Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])) + 1;

            r++;
        }
        return count;
    }

}
