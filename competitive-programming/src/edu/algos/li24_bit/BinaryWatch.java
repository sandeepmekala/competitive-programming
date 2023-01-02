package edu.algos.li24_bit;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

	public static void main(String[] args) {
		BinaryWatch obj = new BinaryWatch();
		
		System.out.println(obj.readBinaryWatch(1));
	}

	/*
	 * Problem: https://leetcode.com/problems/binary-watch/
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
