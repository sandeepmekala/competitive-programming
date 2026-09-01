import java.util.LinkedList;
import java.util.List;

import com.algos.topics.models.Pair;

public class DesignHashmap {

	public static void main(String[] args) {
		DesignHashmap obj = new DesignHashmap();

		obj.put(1, 1);
		obj.put(2, 2);
		System.out.println(obj.get(1));
		System.out.println(obj.get(3));
		obj.put(2, 1);
		System.out.println(obj.get(2));
		obj.remove(2);
		System.out.println(obj.get(2));
	}

	/*
	 * Problem: https://leetcode.com/problems/design-hashmap/
	 *
	 * */
	List<Pair<Integer, Integer>>[] list;
    int size;
    public DesignHashmap() {
        size = 100;
        list = new LinkedList[size];
    }

    public void put(int key, int value) {
        int ind = hash(key);
        if(list[ind] == null) list[ind] = new LinkedList<Pair<Integer, Integer>>();

        Pair<Integer, Integer> pair = new Pair<>(key, value);
        if(get(key) == -1){
            list[ind].add(pair);
        }else{
            remove(key);
            list[ind].add(pair);
        }
    }

    public int get(int key) {
        int ind = hash(key);
        if(list[ind] == null) return -1;

        for(Pair<Integer, Integer> pair: list[ind]){
            if(pair.getKey() == key)
                return pair.getValue();
        }

        return -1;
    }

    public void remove(int key) {
        int ind = hash(key);
        if(list[ind] == null) return;

        list[ind].removeIf(pair -> pair.getKey() == key);
    }

    private int hash(int key){
        return key%size;
    }
}
