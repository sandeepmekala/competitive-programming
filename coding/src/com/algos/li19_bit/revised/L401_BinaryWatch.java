package  com.algos.li19_bit.revised;

import java.util.ArrayList;
import java.util.List;

public class L401_BinaryWatch {

	public static void main(String[] args) {
		L401_BinaryWatch obj = new L401_BinaryWatch();
		
		System.out.println(obj.readBinaryWatch(1));
	}

	/*
	 * Problem: https://leetcode.com/problems/binary-watch/
     * Idea: Run 2 loops on hr and min. For hr and min, get bit count. 
     * If total bigcount = turnedOn, add that hr and min to list.
	 * Companies: Google
	 * */
	public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for(int i=0; i<12; i++){
            for(int j=0; j<60; j++){
                StringBuffer sb = new StringBuffer();
                int hrBits = Integer.bitCount(i);
                int minBits = Integer.bitCount(j);
                if(hrBits+minBits == turnedOn){
                    sb.append(i);
                    sb.append(":");
                    if(j<10) sb.append("0");
                    sb.append(j);
                    
                    result.add(sb.toString());
                }
            }
        }
        
        return result;
    }
}
