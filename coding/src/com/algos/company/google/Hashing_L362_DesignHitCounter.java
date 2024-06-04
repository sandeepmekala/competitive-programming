package com.algos.company.google;

import java.util.HashMap;
import java.util.Map;

public class Hashing_L362_DesignHitCounter {
    public static void main(String[] args) {
        Hashing_L362_DesignHitCounter obj = new Hashing_L362_DesignHitCounter();
        HitCounter counter = new HitCounter();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println(counter.getHits(4));
        counter.hit(300);
    }
}

// Problem: https://leetcode.ca/2018-12-05-362-Design-Hit-Counter/
// Idea: Store the timestamp and count in a map. While getting the hits, iterate over the map and check if the timestamp is within the range of 300 seconds.
// Time: O(n)
class HitCounter {

    private Map<Integer, Integer> counter;

    public HitCounter() {
        counter = new HashMap<>();
    }

    public void hit(int timestamp) {
        counter.put(timestamp, counter.getOrDefault(timestamp, 0) + 1);
    }

    public int getHits(int timestamp) {
        int hits = 0;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getKey() > timestamp - 300) {
                hits += entry.getValue();
            }
        }
        return hits;
    }
}