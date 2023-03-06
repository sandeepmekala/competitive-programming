package edu.algos.li08_greedy;

import java.util.Arrays;

public class G02_FractionalKnapsack {
    public static void main(String args[]) {
        G02_FractionalKnapsack obj = new G02_FractionalKnapsack();

        int n = 3, weight = 50;
        Item arr[] = {new Item (100,20),new Item(60,10),new Item(120,30)};
        double ans = obj.fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is "+ans);
    }

    public double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr,(i1, i2) -> {
            double r1 = (double)(i1.value) / (double)(i1.weight); 
            double r2 = (double)(i2.value) / (double)(i2.weight); 
            
            return (int)(r2-r1);
        }); 
        
        int curWeight = 0; 
        double curvalue = 0.0; 
        for (int i = 0; i < n; i++) {
            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                curvalue += arr[i].value;
            } else {
                int remain = W - curWeight;
                curvalue += ((double)arr[i].value / (double)arr[i].weight) * (double)remain;
                break;
            }
        }
     
        return curvalue;
    }
}

class Item {
    int value, weight;
    Item(int x, int y) {
      this.value = x;
      this.weight = y;
    }
  }