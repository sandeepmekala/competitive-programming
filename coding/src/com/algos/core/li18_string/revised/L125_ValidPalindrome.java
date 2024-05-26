package  com.algos.core.li18_string.revised;

public class L125_ValidPalindrome {

	public static void main(String[] args) {
		L125_ValidPalindrome obj = new L125_ValidPalindrome();
		String s = "A man, a plan, a canal: Panama";
		//String s = "race a car";
		//String s = "0P";
		System.out.println(obj.isPalindrome(s));
	}
	
    // Problem: https://leetcode.com/problems/valid-palindrome/
    // Idea: Convert string to lowercase. Move front and back ptrs. Skip non-alphanumeric.
	public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l=0, r=s.length()-1;
        while(l<r){
            if(!(s.charAt(l) >= 'a' && s.charAt(l) <= 'z') &&
              !(s.charAt(l) >= '0' && s.charAt(l) <= '9')){
                l++;
                continue;
            }else if(!(s.charAt(r) >= 'a' && s.charAt(r) <= 'z') &&
                    !(s.charAt(r) >= '0' && s.charAt(r) <= '9')){
                r--;
                continue;
            }else{
                if(s.charAt(l) != s.charAt(r)){
                    return false;
                }
                l++; r--;
            }
        }
        return true;
    }
}
