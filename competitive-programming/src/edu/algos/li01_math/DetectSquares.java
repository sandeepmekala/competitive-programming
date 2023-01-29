package edu.algos.li01_math;

import java.util.ArrayList;
import java.util.HashMap;

import edu.algos.li00_model.Pair;

class DetectSquares {
	
	HashMap<Pair<Integer, Integer>, Integer> map;
	ArrayList<Pair<Integer, Integer>> list;

	public DetectSquares() {
		map = new HashMap<>();
		list = new ArrayList<>();
	}

	public static void main(String args[]) {
		DetectSquares obj = new DetectSquares();
		obj.add(new int[] {3, 10});
		obj.add(new int[] {11, 2});
		obj.add(new int[] {3, 2});	
		System.out.println(obj.count(new int[] {11, 10}));
	}
	
	public void add(int[] point) {
		Pair<Integer, Integer> pair = new Pair<Integer, Integer>(point[0], point[1]);
		map.put(pair, map.getOrDefault(pair, 0) + 1);
		list.add(pair);
	}

	public int count(int[] point) {
        Pair<Integer, Integer> p1 = new Pair<>(point[0], point[1]);
        int count = 0;
        for(Pair<Integer, Integer> p2: list){
                if(abs(p1.getKey()-p2.getKey()) != abs(p1.getValue()-p2.getValue()) || p1.getKey() == p2.getKey() || p1.getValue() == p2.getValue()) {
                    continue;
                }
                
                Pair<Integer, Integer> bottom = new Pair<>(p1.getKey(), p2.getValue());
                Pair<Integer, Integer> top = new Pair<>(p2.getKey(), p1.getValue());

                count += map.getOrDefault(top, 0)*map.getOrDefault(bottom, 0);
        }
        
        return count;
    }

	private int abs(int num) {
		return Math.abs(num);
	}
}
