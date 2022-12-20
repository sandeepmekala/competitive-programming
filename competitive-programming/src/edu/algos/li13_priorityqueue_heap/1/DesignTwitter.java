package edu.algos.li13_priorityqueue_heap.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class DesignTwitter {

	public static void main(String[] args) {
		DesignTwitter obj = new DesignTwitter();
		
		obj.postTweet(1, 5);
		System.out.println(obj.getNewsFeed(1));
		obj.follow(1, 2);
		obj.postTweet(2, 6);
		System.out.println(obj.getNewsFeed(1));
		obj.unfollow(1, 2);
		System.out.println(obj.getNewsFeed(1));
	}
	
	HashMap<Integer, HashSet<Integer>> follows;
    HashMap<Integer, ArrayList<Twit>> twits;
    int time = 0;
    public DesignTwitter() {
        follows = new HashMap<>();
        twits = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        if(!twits.containsKey(userId)){
            twits.put(userId, new ArrayList<Twit>());
        }
        twits.get(userId).add(new Twit(tweetId, time));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweets = new ArrayList<>();
        PriorityQueue<Twit> pq = new PriorityQueue<>((t1,t2)->t2.time-t1.time);
        
        ArrayList<Twit> ts = twits.getOrDefault(userId, new ArrayList<Twit>());
        for(int i=ts.size()-1; i>=0; i--){
            pq.add(ts.get(i));
        }
        
        HashSet<Integer> following = follows.getOrDefault(userId, new HashSet<Integer>());
        for(int followeeId: following){
            ts = twits.getOrDefault(followeeId, new ArrayList<Twit>());
            for(int i=ts.size()-1; i>=0; i--){
                pq.add(ts.get(i));
            }
        }
        
        int count=0;
        while(count<10 && !pq.isEmpty()){
            tweets.add(pq.remove().twittId);
            count++;
        }
        return tweets;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!follows.containsKey(followerId)){
            follows.put(followerId, new HashSet<Integer>());
        }
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follows.containsKey(followerId)){
            follows.get(followerId).remove(followeeId);
        }
    }

}
class Twit{
    int twittId;
    int time;
    Twit(int twittId, int time){
        this.twittId = twittId;
        this.time = time;
    }
    
}
