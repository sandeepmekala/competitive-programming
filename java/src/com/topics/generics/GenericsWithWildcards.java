package com.java.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsWithWildcards {

        public static void main(String[] args) {
            GenericsWithWildcards gw = new GenericsWithWildcards();
            List<Integer> l1 = new ArrayList<>();

            // This gives compilation error as List<Integer> is not a subtype of List<Object>
            // But only Integer is a subtype of Object.
            // This is where we can use wildcards to generalize the functionality to different types of classes.
            //gm.print(l1);

            List<Double> l2 = new ArrayList<>();
            gw.print(l2);
        }

        // We can use wildcards to generalize the functionality to different types of classes.
        // public void print(List<Object> list){
        //     System.out.println(list);
        // }

        public void print(List<?> list){
            System.out.println(list);
        }

        // We can also have bounded wildcards.
        public void print2(List<? extends Animal> list){
            System.out.println(list);
        }
}
