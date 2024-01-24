package  com.algos.li03_interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L986_IntervalListIntersections {
    public static void main(String[] args) {
        L986_IntervalListIntersections obj = new L986_IntervalListIntersections();

        int[][] firstList = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = new int[][]{{1,5},{8,12},{15,24},{25,26}};

        int[][] result = obj.intervalIntersection(firstList, secondList);
        for(int[] interval: result){
            System.out.println(Arrays.toString(interval));
        }
    }

    // Problem: https://leetcode.com/problems/interval-list-intersections/
    // Idea: Use two pointers and check if two intervals from lists overlaps using criss crossing.
    // Take the max of starts and min of ends to find the intersection interval
    // Move the ptr whose interval is ending first because longer interval might intersect with subsequence intervals.
    public int[][] intervalIntersection(int[][] first, int[][] second) {
        int m = first.length, n = second.length;

        List<int[]> result = new ArrayList<>();
        int i=0, j=0;
        while(i<m && j<n){   
            if(second[j][0]<=first[i][1] && second[j][1] >= first[i][0]){   // Criss crossing. Works even if second is ahead of first or later.
                int start = Math.max(first[i][0], second[j][0]);
                int end = Math.min(first[i][1], second[j][1]);
                result.add(new int[]{start, end});
            }

            if(first[i][1] < second[j][1])
                i++;
            else 
                j++;
        }

        return result.toArray(new int[result.size()][2]);
    }
}
