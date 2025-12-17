
public class L520_DetectCapital {

	public static void main(String[] args) {
		L520_DetectCapital obj = new L520_DetectCapital();

		String word = "USA";
		System.out.println(obj.detectCapitalUse(word));
	}

	/*
	 * Problem: https://leetcode.com/problems/detect-capital/
	 * Idea: Use startCapital and continuesCapital vars to track the status
     * TODO
	 * */
	public boolean detectCapitalUse(String word) {
		boolean startsCap = false, continuesCap = false;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(i == 0)
                if(ch>='A' && ch<='Z') { startsCap = true; continue; }
            if(i == 1)
                if(ch>='A' && ch<='Z') continuesCap = true;

            if(startsCap && continuesCap && ch>='a' && ch<='z') return false;
            if(startsCap && !continuesCap && ch>='A' && ch<='Z') return false;
            if(!startsCap && ch>='A' && ch<='Z') return false;
        }

        return true;
    }

}
