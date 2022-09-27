package edu.java.java8.li08.map;

import java.util.HashMap;
import java.util.Map;

public class MapDeflautMethods {
    public static void main(String[] args) {
        // Map -------------------------------------------------------------
		// maps don't support streams but added many useful methods
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "San");
		for (int i = 0; i < 10; i++) {
			map.putIfAbsent(i, "val" + i);
		}
		map.forEach((id, value) -> {
			System.out.println(value);
		});

		map.computeIfPresent(3, (key, val) -> val + key);
		System.out.println(map.get(3));

		map.computeIfPresent(9, (key, val) -> null);
		System.out.println(map.containsKey(9));

		map.computeIfAbsent(23, (key) -> "val" + key);
		System.out.println(map.containsKey(23));

		map.computeIfAbsent(3, (key) -> "foo");
		System.out.println(map.get(3));

		map.remove(3, "val3");
		System.out.println(map.get(3));

		map.remove(3, "val33");
		System.out.println(map.get(3));

		System.out.println(map.getOrDefault(42, "not found"));

		// this is extremely useful for counting
		map.merge(9, "val9", (value, newvalue) -> value.concat(newvalue));
		System.out.println(map.get(9));

		map.merge(9, "newvalue", (value, newvalue) -> value.concat(newvalue));
		System.out.println(map.get(9));

		// Map -------------------------------------------------------------
    }
}
