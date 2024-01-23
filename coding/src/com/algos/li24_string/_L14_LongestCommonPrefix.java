package  com.algos.li24_string;

public class _L14_LongestCommonPrefix {

	public static void main(String[] args) {
		_L14_LongestCommonPrefix obj = new _L14_LongestCommonPrefix();

		System.out.println(obj.longestCommonPrefix(new String[] {"cir","car"}));
	}
	
    // Problem: https://leetcode.com/problems/longest-common-prefix/
    // Idea: Next loops compare the string and track min matching len.
    // TODO
    public String longestCommonPrefix(String[] strs) {
        String base = strs[0];
        int minlen = base.length();
        for(int i=1; i<strs.length; i++){
            String str = strs[i];
            int len = 0;
            for(int j=0; j<str.length(); j++){
                if(j<base.length() && base.charAt(j) == str.charAt(j)){
                    len++;
                }else {
                	break;
                }
            }
            minlen = Math.min(minlen, len);
        }

        return base.substring(0,minlen);
    }

}
