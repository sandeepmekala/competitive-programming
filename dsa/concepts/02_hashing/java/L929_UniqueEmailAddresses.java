import java.util.HashSet;
import java.util.Set;

public class L929_UniqueEmailAddresses {

	public static void main(String[] args) {
		L929_UniqueEmailAddresses obj = new L929_UniqueEmailAddresses();

		String[] emails = new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		System.out.println(obj.numUniqueEmails(emails));
	}

	/*
	 * Problem: https://leetcode.com/problems/unique-email-addresses/
     * Idea: Collect distinct email in a set
	 * */
	public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email: emails){
            boolean ignore = false;
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<email.length(); i++){
                char ch = email.charAt(i);
                if(ch == '.') continue;
                else if(ch == '+') ignore = true;
                else if(ch == '@') {
                    sb.append(email.substring(i));
                    break;
                }
                else if(!ignore) sb.append(ch);
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}
