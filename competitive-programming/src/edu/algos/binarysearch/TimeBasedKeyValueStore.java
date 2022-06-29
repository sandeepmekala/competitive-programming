package edu.algos.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeBasedKeyValueStore {
	
	public static void main(String[] args) {
		TimeBasedKeyValueStore obj = new TimeBasedKeyValueStore();
		
		obj.set("foo","bar",1);
		System.out.println(obj.get("foo",1));
		System.out.println(obj.get("foo",3));
		obj.set("foo","bar2",4);
		System.out.println(obj.get("foo",4));
		System.out.println(obj.get("foo",5));
	}
	
	
	HashMap<String, ArrayList<Pair>> map;
    public TimeBasedKeyValueStore() {
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
        int l=0, r=list.size()-1;
        String res = "";
        while(l<=r){
            int mid = (l+r)/2;
            Pair pair = list.get(mid);
            if(pair.time <= timestamp){
                res = pair.val;
                l = mid+1;
            }else{
                r = mid-1;
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
