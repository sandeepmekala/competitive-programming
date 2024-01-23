package  com.algos.li21_design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class InsertDeleteGetrandomO1 {

	public static void main(String[] args) {
		InsertDeleteGetrandomO1 obj = new InsertDeleteGetrandomO1();
		
		System.out.println(obj.insert(1));
		System.out.println(obj.remove(2));
		System.out.println(obj.insert(2));
		System.out.println(obj.getRandom());
		System.out.println(obj.remove(1));
		System.out.println(obj.insert(2));
		System.out.println(obj.getRandom());
	}

	/*
	 * Problem: https://leetcode.com/problems/insert-delete-getrandom-o1/
	 * Companies: Amazon
	 * */
	HashMap<Integer, Integer> map;
    List<Integer> list;
    Random r;
    public InsertDeleteGetrandomO1() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val, list.size());
            list.add(val);
            
            return true;
        }
        
        return false;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int valInd = map.get(val);
            int lastOne = list.get(list.size()-1);
            
            if(valInd < list.size()-1){
                list.set(valInd, lastOne);
                map.put(lastOne, valInd);                
            }
            
            list.remove(list.size()-1);
            map.remove(val);
            
            return true;
        }
        
        return false;
    }
    
    public int getRandom() {
        int ind = r.nextInt(list.size());
        return list.get(ind);
    }
}
