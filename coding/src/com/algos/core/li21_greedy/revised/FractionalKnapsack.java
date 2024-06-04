package  com.algos.core.li21_greedy.revised;

import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String args[]) {
        FractionalKnapsack obj = new FractionalKnapsack();

        int n = 3, wt = 50;
        Item[] items = {
            new Item (100,20),
            new Item(60,10),
            new Item(120,30)};
        System.out.println(obj.fractionalKnapsack(wt, items, n));
    }

    // Problem: https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
    // Idea: Greedy: Sort the items based on value/weight ratio. Pick the item with max value/weight ratio.
    // Time: O(nlogn)
    public double fractionalKnapsack(int wt, Item[] items, int n) {
        Arrays.sort(items,(i1, i2) -> {
            return (int)((double)(i2.value) / (double)(i2.weight)-
            ((double)(i1.value) / (double)(i1.weight)));
        }); 
        
        double totValue = 0.0; 
        for (int i = 0; i < n; i++) {
            if (items[i].weight <= wt) {
                wt -= items[i].weight;
                totValue += items[i].value;
            } else {
                totValue += ((double)items[i].value / (double)items[i].weight) * wt;
                break;
            }
        }
     
        return totValue;
    }
}

class Item {
    int value, weight;
    Item(int x, int y) {
      this.value = x;
      this.weight = y;
    }
}