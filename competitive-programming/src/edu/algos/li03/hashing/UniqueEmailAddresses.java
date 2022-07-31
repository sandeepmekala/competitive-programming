package edu.algos.li03.hashing;

import java.util.HashSet;

public class UniqueEmailAddresses {

	public static void main(String[] args) {
		UniqueEmailAddresses obj = new UniqueEmailAddresses();
		
		String[] emails = new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		System.out.println(obj.numUniqueEmails(emails));
	}

	/*
	 * Problem: https://leetcode.com/problems/unique-email-addresses/
	 * */
	public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(String email: emails){
            boolean ignore = false;
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<email.length(); i++){
                char ch = email.charAt(i);
                if(ch == '.') continue;
                else if(ch == '+') ignore = true;
                else if(ch == '@') {
                    sb.append(email.substring(i));
                    ignore = false;
                    break;
                }
                else if(!ignore) sb.append(ch);
            }
            set.add(sb.toString());
        }
                          
        return set.size();
    }
}
