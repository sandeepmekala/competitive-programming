package com.java.concurrency.collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ForkJoinPool;

public class A015ConcurrentMap {

	public static void main(String[] args) {
		ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
		map.put("foo", "bar");
		map.put("han", "solo");
		map.put("r2", "d2");
		map.put("c3", "p0");

		map.forEach((key, value) -> System.out.println(key + "=" + value));

		String value1 = map.putIfAbsent("c3", "p1");
		System.out.println(value1); // p0

		String value2 = map.getOrDefault("hi", "there");
		System.out.println(value2); // there

		map.replaceAll((key, value) -> "r2".equals(key) ? "d3" : value);
		System.out.println(map.get("r2")); // d3

		map.compute("foo", (key, value) -> value + value);
		System.out.println(map.get("foo")); // barbar

		map.merge("foo", "boo", (oldVal, newVal) -> newVal + " was " + oldVal);
		System.out.println(map.get("foo")); // boo was foo

		map.forEach((key, value) -> System.out.println(key + "=" + value));

		System.out.println(ForkJoinPool.getCommonPoolParallelism());


		ConcurrentHashMap<String, String> map2 = new ConcurrentHashMap<>();
		map2.put("foo", "bar");
		map2.put("han", "solo");
		map2.put("r2", "d2");
		map2.put("c3", "p0");

		// ForEach
		map2.forEach(1, (key, value) -> System.out.printf("key: %s; value: %s; thread: %s\n", key, value,
				Thread.currentThread().getName()));

		// Search
		// As soon as a non-null value is returned, furhter processing is suppressed
		String result1 = map2.search(1, (key, value) -> {
			System.out.println(Thread.currentThread().getName());
			if ("foo".equals(key)) {
				return value;
			}
			return null;
		});
		System.out.println("Result: " + result1);

		// Reduce
		String result2 = map2.reduce(1, (key, value) -> {
			System.out.println("Transform: " + Thread.currentThread().getName());
			return key + "=" + value;
		}, (s1, s2) -> {
			System.out.println("Reduce: " + Thread.currentThread().getName());
			return s1 + ", " + s2;
		});

		System.out.println("Result: " + result2);
	}
}
