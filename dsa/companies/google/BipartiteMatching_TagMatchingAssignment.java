
import java.util.*;

public class BipartiteMatching_TagMatchingAssignment {

    public boolean find(Map<Integer, List<String>> graph, int qid, Set<String> vis, Map<String, Integer> vtoq) {
        for (String vid : graph.get(qid)) {
            if (!vis.contains(vid)) {
                vis.add(vid);
                if (!vtoq.containsKey(vid) || find(graph, vtoq.get(vid), vis, vtoq)) {
                    vtoq.put(vid, qid);
                    return true;
                }
            }
        }
        return false;
    }

    // Perform: https://leetcode.com/discuss/interview-question/4820505/Google-question/
    public Map<String, Integer> maxBipartiteMatching(List<Question> ques, List<Volunteer> vols) {
        Map<Integer, List<String>> graph = new HashMap<>();

        // O(Q * V * T) time complexity, where Q is the number of questions, V is the number of volunteers, and T is the number of tags
        for (Question q : ques) {
            graph.putIfAbsent(q.id, new ArrayList<>());
            for (Volunteer v : vols) {
                for (String tag : q.tags) {
                    if (v.tags.contains(tag)) {
                        graph.get(q.id).add(v.id);
                        break;
                    }
                }
            }
        }

        // O(Q * V) time complexity
        Map<String, Integer> match = new HashMap<>();
        Set<String> vis = new HashSet<>();
        for (Question q : ques) {
            vis.clear();
            find(graph, q.id, vis, match);
        }

        return match;
    }

    public static void main(String[] args) {
        BipartiteMatching_TagMatchingAssignment bm = new BipartiteMatching_TagMatchingAssignment();

        List<Question> ques = new ArrayList<>();
        ques.add(new Question(1, new HashSet<>(Arrays.asList("MAC", "VSCODE"))));
        ques.add(new Question(2, new HashSet<>(Arrays.asList("PY", "AI"))));
        ques.add(new Question(3, new HashSet<>(Arrays.asList("JAVA", "OS"))));
        ques.add(new Question(4, new HashSet<>(Arrays.asList("PY", "NW"))));

        List<Volunteer> vols = new ArrayList<>();
        vols.add(new Volunteer("1", "A", new HashSet<>(Arrays.asList("PY", "NW"))));
        vols.add(new Volunteer("2", "B", new HashSet<>(Arrays.asList("AI"))));
        vols.add(new Volunteer("3", "C", new HashSet<>(Arrays.asList("JAVA", "NW"))));
        vols.add(new Volunteer("4", "D", new HashSet<>(Arrays.asList("JAVA", "NW"))));

        var vtoq = bm.maxBipartiteMatching(ques, vols);
        System.out.println(vtoq);
    }
}

class Question {
    int id;
    Set<String> tags;

    Question(int id, Set<String> tags) {
        this.id = id;
        this.tags = tags;
    }
}

class Volunteer {
    String id;
    String name;
    Set<String> tags;

    Volunteer(String id, String name, Set<String> tags) {
        this.id = id;
        this.name = name;
        this.tags = tags;
    }
}
