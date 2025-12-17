public class L482_LicenseKeyFormatting {

	public static void main(String[] args) {
		L482_LicenseKeyFormatting obj = new L482_LicenseKeyFormatting();

		String s = "5F3Z-2e-9-w";
		System.out.println(obj.licenseKeyFormatting(s, 4));
	}

	/*
	 * Problem: https://leetcode.com/problems/license-key-formatting/
	 * Idea: Go right to left as first group can have less chars.
	 * */
	public String licenseKeyFormatting(String s, int k) {
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for(int i=s.length()-1; i>=0; i--){

            char ch = s.charAt(i);
            if(ch == '-') continue;

            if(count == k){
                sb.append('-');
                count = 0;
            }
            sb.append(Character.toUpperCase(ch));
            count++;
        }

        return sb.reverse().toString();
    }

}
