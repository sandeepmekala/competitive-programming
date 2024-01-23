package  com.algos.li24_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L659_EncodeAndDecodeStrings {

	public static void main(String[] args) {
		L659_EncodeAndDecodeStrings obj = new L659_EncodeAndDecodeStrings();
		String encoded = obj.encode(new ArrayList<String>(Arrays.asList("lintsfsdkjfsdkfjsdkfsd","code","love","you")));
		System.out.println(encoded);
		System.out.println(obj.decode(encoded));
	}

    // Problem: https://www.lintcode.com/problem/659/
    // Idea: You can't use simple delimieter as strings can also contain that delimiter.
    // You solve that, you have to store no of chars in each word.
    // But this number can agian conflict with ints that can be there in words like ab23d.
    // Hence, introduce a simbal after number to idetify that this number is used by us.
	public String encode(List<String> strs) {
        StringBuffer result = new StringBuffer();
        String delimeter = "#";
        for(int i=0; i<strs.size(); i++){
            result.append(strs.get(i).length());
            result.append(delimeter); 
            result.append(strs.get(i));
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<String>();
        int i=0;
        while(i<str.length()){
            int delimiterInd = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, delimiterInd));
            
            int begInd = delimiterInd+1;
            int endInd = begInd+length;
            result.add(str.substring(begInd, endInd));
            i = endInd;
        }
        return result;
    }
}
