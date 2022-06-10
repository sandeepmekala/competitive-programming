package edu.algos.greedy;

import java.util.ArrayList;
import java.util.Comparator;

public class ActivitySelection {

	public static void main(String[] args) {
		ArrayList<Activity> activities = new ArrayList<Activity>();
		activities.add(new Activity(5,9));
		activities.add(new Activity(1,2));
		activities.add(new Activity(3,4));
		activities.add(new Activity(0,6));
		activities.add(new Activity(5,7));
		activities.add(new Activity(8,9));
		
		printMaxActivities(activities);
	}
	
	//concept: sort the activities based on finish time and start pickining activities if start of that activity >= end time of previous activity
	private static void printMaxActivities(ArrayList<Activity> activities) {
		activities.sort(new Comparator<Activity>(){

			@Override
			public int compare(Activity o1, Activity o2) {
				return o1.end - o2.end;
			}
			
		});
		
		Activity prev = activities.get(0);
		prev.print();
		for(Activity activity: activities) {
			if(activity.start >= prev.end) {
				activity.print();
				prev = activity;
			}
		}
	}

}
class Activity{
	public int start;
	public int end;
	
	Activity(int start, int end){
		this.start = start;
		this.end = end;
	}
	public void print() {
		System.out.println(this.start+" : "+this.end);
	}
}