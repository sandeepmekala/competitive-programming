
public class String_ValidParenthesisString2 {

    public static boolean checkValidString(String s) {
        int min = 0, max = 0;
        int[] deleteCount = new int[s.length()]; // Track deletions needed

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                min++;
                max++;
            } else if (ch == ')') {
                min--;
                max--;
            } else {
                int deletions = ch - '0';
                if (min < deletions) {
                    return false; // Not enough parentheses to delete
                }
                min -= deletions;
                if (min < 0) {
                    min = 0; // Cannot have negative minimum
                }
                max -= deletions;
            }

            if (min < 0) {
                min = 0;
            }
            if (max < min) {
                return false; // max should always be >= min
            }
        }

        return min == 0; // The string is balanced if min is zero
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("((2))")); // Output: false
        System.out.println(checkValidString("((((2))")); // Output: true
        System.out.println(checkValidString("(()1(1))")); // Output: true
    }
}
