package  com.algos.li06_binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L981_TimeBasedKeyValueStore {
	
	public static void main(String[] args) {
		L981_TimeBasedKeyValueStore obj = new L981_TimeBasedKeyValueStore();
		
		obj.set("foo","bar",1);
		System.out.println(obj.get("foo",1));
		System.out.println(obj.get("foo",3));
		obj.set("foo","bar2",4);
		System.out.println(obj.get("foo",4));
		System.out.println(obj.get("foo",5));
	}
	
	// Problem: https://leetcode.com/problems/time-based-key-value-store/
    // Idea: Use BS to find closest time to target time
	HashMap<String, ArrayList<Pair>> map;
    public L981_TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<Pair>());
        }
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<Pair>());
        int left=0, right=list.size()-1;
        String res = "";
        while(left<=right){
            int mid = (left+right)/2;
            Pair pair = list.get(mid);
            if(timestamp >= pair.time ){
                res = pair.val;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        
        return res;
    }
}

class Pair{
    String val;
    int time;    
    
    Pair(String val, int time){
        this.val = val;
        this.time = time;
    }
}
