package edu.algos.li12_stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import edu.algos.li00_model.Pair;

public class CarFleet {

	public static void main(String[] args) {
		CarFleet obj = new CarFleet();
		
		System.out.println(obj.carFleet(12, new int[] {10,8,0,5,3}, new int[] {2,4,1,1,3}));
	}

	public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<Pair<Integer, Integer>> cars = new ArrayList<Pair<Integer, Integer>>();
        for(int i=0; i<position.length; i++){
            Pair<Integer, Integer> car = new Pair<>(position[i], speed[i]);
            cars.add(car);
        }
        Collections.sort(cars,(c1, c2)->{
            return c1.getKey()-c2.getKey();
        });
        
        Stack<Pair<Integer, Integer>> stack =  new Stack<Pair<Integer, Integer>>();
        for(int i=cars.size()-1; i>=0; i--){
            Pair<Integer, Integer> car = cars.get(i); 
            if(stack.isEmpty()){
                stack.push(car);
                continue;
            }
            
            if(time(car, target) > time(stack.peek(), target)){
                stack.push(car);
            }
        }
        
        return stack.size();
    }
    
    private double time(Pair<Integer, Integer> car, int target){
        return ((target-car.getKey())*1.0)/car.getValue();
    }
}
