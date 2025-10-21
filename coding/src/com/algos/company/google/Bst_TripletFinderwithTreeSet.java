package com.algos.company.google;

import java.util.Arrays;
import java.util.TreeSet;

class Bst_TripletFinderwithTreeSet {

    public static void main(String[] args) {
        TripletFinder obj = new TripletFinder();
        obj.init(5);
        obj.func(1.0f);
        obj.func(10.0f);
        obj.func(7.0f);
        obj.func(-2.0f);
        obj.func(8.0f);
    }
}

// Problem: https://leetcode.com/discuss/interview-question/4964533/Google-Phone-Interview-Question
class TripletFinder{
    private int D;
	//tree set will help to maintain ordered list of items
	TreeSet<Float> nums;

	//TC - O(1)
	void init(int d) {
		this.D = d;
		nums = new TreeSet<>();
	}

	//TC - O(logN) where N is current items count
	void func(float b) {

        // Case 1 :
        /*
         *   a . . b . . c (a < b < c)
         * */
        Float a = nums.floor(b);
        Float c = nums.ceiling(b);
        if (a != null && c != null && Math.abs(a - b) <= D && Math.abs(b - c) <= D) {
            nums.remove(a);
            nums.remove(c);
            System.out.println(Arrays.asList(a, b, c));
            return;
        }

        // Case 2 :
        /*
         *       b . . a . . c (b < a < c)
         * */
        a = nums.ceiling(b);
        c = a != null ? nums.ceiling(a+1) : null;
        if (a != null && c != null && Math.abs(b - a) <= D && Math.abs(a - c) <= D) {
            nums.remove(a);
            nums.remove(c);
            System.out.println(Arrays.asList(b, a, c));
            return;
        }

        // Case 3 :
        /*
         *       c . . a . . b (b < a < c)
         * */
        a = nums.floor(b);
        c = a != null ? nums.floor(a-1) : null;
        if (a != null && c != null && Math.abs(c - a) <= D && Math.abs(a - b) <= D) {
            nums.remove(a);
            nums.remove(c);
            System.out.println(Arrays.asList(c, a, b));
            return;
        }

        nums.add(b);
    }
}
