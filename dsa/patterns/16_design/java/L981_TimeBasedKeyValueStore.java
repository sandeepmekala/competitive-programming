import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L981_TimeBasedKeyValueStore {

	public static void main(String[] args) {
		TimeMap obj = new TimeMap();

		obj.set("foo","bar",1);
		System.out.println(obj.get("foo",1));
		System.out.println(obj.get("foo",3));
		obj.set("foo","bar2",4);
		System.out.println(obj.get("foo",4));
		System.out.println(obj.get("foo",5));
	}
}
// Problem: https://leetcode.com/problems/time-based-key-value-store/
// Idea: Use BS to find closest time to target time
// Time complexity: O(logn)
// Follow ups:
//  i) how to delete a key
//  ii) how to implement a multi thread version
class TimeMap{
	HashMap<String, ArrayList<Pair>> map;   // [key = (value, timestamp)]
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        int low=0, high=list.size()-1;
        String res = "";
        while(low <= high){
            int mid = (low+high)/2;
            Pair pair = list.get(mid);
            if(pair.time <= timestamp){
                res = pair.val;
                low = mid+1;
            }else{
                high = mid-1;
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
