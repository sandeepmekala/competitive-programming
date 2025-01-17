package  com.algos.core.li07_stack.revised;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Mono_L853_CarFleet {

	public static void main(String[] args) {
		Mono_L853_CarFleet obj = new Mono_L853_CarFleet();
		
		System.out.println(obj.carFleet(12, new int[] {10,8,0,5,3}, new int[] {2,4,1,1,3}));
	}

    // Problem: https://leetcode.com/problems/car-fleet/description/
    // Idea: Move right to left and build monotanically increasing stack of times.
    // time = dist / speed
    // Every element greater then top of the stack halts the traffic behind it. Push it on to stack.
	public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        List<Car> cars = new ArrayList<>();
        for(int i=0; i<n; i++)
            cars.add(new Car(position[i], speed[i]));
        
        Collections.sort(cars, (c1, c2)-> c1.pos-c2.pos);
        
        Stack<Car> s = new Stack<>();
        for(int i=n-1; i>=0; i--){
            Car car = cars.get(i);
            if(s.isEmpty() || time(car, target) > time(s.peek(), target)){
                s.push(car);
            }
        }
        
        return s.size();
    }
    
    private double time(Car car, int target){
        return ((target-car.pos)*1.0)/car.speed;
    }
}
class Car{
    int pos;
    int speed;
    Car(int position, int speed){
        this.pos = position;
        this.speed = speed;
    }
}