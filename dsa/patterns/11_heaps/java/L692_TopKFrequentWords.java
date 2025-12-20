import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class L692_TopKFrequentWords {

	public static void main(String[] args) {
		L692_TopKFrequentWords obj = new L692_TopKFrequentWords();

		String[] words = new String[] {"i","love","leetcode","i","love","coding"};
		System.out.println(obj.topKFrequent(words, 2));
	}

	/*
	 * Problem: https://leetcode.com/problems/top-k-frequent-words/
	 * Companies: Amazon
	 *
	 * Idea: Hashing and Priority Queue
	 * */
	public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
            if(e1.getValue() == e2.getValue()){
                return e1.getKey().compareTo(e2.getKey());
            }else{
                return e2.getValue() - e1.getValue();
            }
        });

        pq.addAll(map.entrySet());

        List<String> result = new ArrayList<>();
        for(int i=0; i<k; i++){
            if(!pq.isEmpty())
                result.add(pq.remove().getKey());
        }

        return result;
    }

}
