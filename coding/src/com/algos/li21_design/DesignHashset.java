package edu.algos.li21_design;

import java.util.LinkedList;
import java.util.List;

public class DesignHashset {

	public static void main(String[] args) {
		DesignHashset obj = new DesignHashset();
		
		obj.add(1);
		obj.add(2);
		System.out.println(obj.contains(1));
		System.out.println(obj.contains(3));
		obj.add(2);
		System.out.println(obj.contains(2));
		obj.remove(2);
		System.out.println(obj.contains(2));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/design-hashset/
	 * */
	LinkedList<Integer>[] list;
    int size;
    public DesignHashset() {
        size = 100;
        list = new LinkedList[size];
    }
    
    public void add(int key) {
    	int ind = hash(key);
    	if(list[ind] == null) list[ind] = new LinkedList<Integer>();
    	if(list[ind].contains(key)) return;
    	
    	list[ind].add(key);
    }
    
    public void remove(int key) {
    	int ind = hash(key);
        if(list[ind] == null) return;
        
        list[ind].remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        int ind = hash(key);
        if(list[ind] == null) return false;

        return list[ind].contains(key);
    }
    
    private int hash(int key) {
    	return key%size;
    }

}
