
public class L921_MinimumAddtoMakeParenthesesValid {

    public static void main(String[] args) {
        L921_MinimumAddtoMakeParenthesesValid obj = new L921_MinimumAddtoMakeParenthesesValid();
        System.out.println(obj.minAddToMakeValid("())"));	// 1
        System.out.println(obj.minAddToMakeValid("((("));	// 3
        System.out.println(obj.minAddToMakeValid("()"));	// 0
        System.out.println(obj.minAddToMakeValid("()))(("));	// 4
    }

    // Problem: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
    // Idea: Count the number of open parentheses. Cancel out the open parentheses with close parentheses.
    // If open parentheses is 0 to cancel out, then increment the count of close parentheses.
    // Answer: remaining open parentheses + unmatched close parentheses
    // Time: O(n), Space: O(1)
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                open++;
            }else{
                if(open > 0){
                    open--;
                }else{
                    close++;
                }
            }
        }
        return open + close;
    }
}
