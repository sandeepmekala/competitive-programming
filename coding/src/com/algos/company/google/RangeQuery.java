package com.algos.company.google;

import java.util.TreeMap;

public class RangeQuery {

    private final TreeMap<Integer, Integer> map;

    public RangeQuery() {
        map = new TreeMap<>();
    }

    public void insertRange(int start, int end) {
        var left = map.floorEntry(start);
        var right = map.floorEntry(end);

        if(left != null && left.getValue() >= start) {
            start = left.getValue();
        }

        if(right != null && right.getValue() >= end) {
            end = right.getValue();
        }

        map.subMap(start, end).clear();
        map.put(start, end);
    }

    public boolean query(int number) {
        return map.floorEntry(number) != null && map.floorEntry(number).getValue() >=number;
    }

    public static void main(String[] args) {
        RangeQuery obj = new RangeQuery();

        obj.insertRange(2, 5);
        obj.insertRange(9, 13);
        obj.insertRange(6, 100);
        obj.insertRange(4, 10);
        System.out.println(obj.query(6));
        System.out.println(obj.query(10));
    }

}