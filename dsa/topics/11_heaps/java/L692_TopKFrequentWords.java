import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class L692_TopKFrequentWords {

    public static void main(String[] args) {
        L692_TopKFrequentWords obj = new L692_TopKFrequentWords();

        String[] words = new String[] { "i", "love", "leetcode", "i", "love", "coding" };
        System.out.println(obj.topKFrequent(words, 2));
    }

    /*
     * Problem: https://leetcode.com/problems/top-k-frequent-words/
     * Companies: Amazon
     *
     * Idea: Hashing and Priority Queue
     */
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
            if (e1.getValue() == e2.getValue()) {
                return e1.getKey().compareTo(e2.getKey());
            } else {
                return e2.getValue() - e1.getValue();
            }
        });

        pq.addAll(map.entrySet());

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty())
                result.add(pq.remove().getKey());
        }

        return result;
    }

    public List<String> topKFrequentOptimal(String[] words, int k) {

        // 1. Count frequency
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // 2. Min heap containing the WORST element at the top
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> {

            // Lower frequency = lower priority = remove first
            if (!e1.getValue().equals(e2.getValue())) {
                return e1.getValue() - e2.getValue();
            }

            // For same frequency, lexicographically larger word
            // should be removed first
            return e2.getKey().compareTo(e1.getKey());
        });

        // 3. Keep only top k elements
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // 4. PQ gives worst -> best, so add at front
        List<String> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll().getKey());
        }

        // PQ gives elements from worst to best
        Collections.reverse(result);

        return result;
    }
}
