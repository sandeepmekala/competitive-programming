package edu.algos.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {

	public static void main(String[] args) {
		EncodeAndDecodeStrings obj = new EncodeAndDecodeStrings();
		String encoded = obj.encode(new ArrayList<String>(Arrays.asList("lint","code","love","you")));
		System.out.println(encoded);
		System.out.println(obj.decode(encoded));
	}

	public String encode(List<String> strs) {
        String result = "";
        String delimeter = "#";
        for(int i=0; i<strs.size(); i++){
            result += strs.get(i).length()+delimeter+strs.get(i);
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<String>();
        int i=0;
        while(i<str.length()){
            int length = Integer.parseInt(str.charAt(i)+"");
            String word = "";
            for(int j=i+2; j<(i+2+length); j++){
                word += str.charAt(j);
            }
            result.add(word);
            i += length+2;
        }
        return result;
    }
}
