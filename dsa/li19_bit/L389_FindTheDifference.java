
public class L389_FindTheDifference {

	public static void main(String[] args) {
		L389_FindTheDifference obj = new L389_FindTheDifference();

		System.out.println(obj.findTheDifference("acd", "aedc"));
	}

	/*
	 * Problem: https://leetcode.com/problems/find-the-difference/
	 * Companies: Google
     * Idea: s and t has chars repeating. Hence do xor to eliminate all the repeating chars.
     * At the end, the odd char remains.
	 * */
	public char findTheDifference(String s, String t) {
        int chr = 0;
        for(char ch: s.toCharArray()){
            chr ^= ch;
        }
        for(char ch: t.toCharArray()){
            chr ^= ch;
        }

        return (char)chr;
    }

}
