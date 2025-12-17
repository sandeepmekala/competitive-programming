
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class L355_DesignTwitter {

	public static void main(String[] args) {
		L355_DesignTwitter obj = new L355_DesignTwitter();

		obj.postTweet(1, 5);
		System.out.println(obj.getNewsFeed(1));
		obj.follow(1, 2);
		obj.postTweet(2, 6);
		System.out.println(obj.getNewsFeed(1));
		obj.unfollow(1, 2);
		System.out.println(obj.getNewsFeed(1));
	}

    // Problem: https://leetcode.com/problems/design-twitter/
    // Idea: Use pq to order tweets based on time.
	Map<Integer, HashSet<Integer>> follows;
    Map<Integer, ArrayList<Twit>> twits;
    int time = 0;
    public L355_DesignTwitter() {
        follows = new HashMap<>();
        twits = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        time++;
        twits.putIfAbsent(userId, new ArrayList<>());
        twits.get(userId).add(new Twit(tweetId, time));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweets = new ArrayList<>();
        Queue<Twit> pq = new PriorityQueue<>((t1,t2)->t2.time-t1.time);

        // user tweets
        List<Twit> ts = twits.getOrDefault(userId, new ArrayList<>());
        for(int i=ts.size()-1; i>=0; i--){
            pq.add(ts.get(i));
        }

        HashSet<Integer> following = follows.getOrDefault(userId, new HashSet<>());
        for(int followeeId: following){
            ts = twits.getOrDefault(followeeId, new ArrayList<>());
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
        follows.putIfAbsent(followerId, new HashSet<>());
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
