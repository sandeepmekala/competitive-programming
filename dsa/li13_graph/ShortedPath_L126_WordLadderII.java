package li13_graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ShortedPath_L126_WordLadderII {
    public static void main(String[] args) throws IOException {
        ShortedPath_L126_WordLadderII obj = new ShortedPath_L126_WordLadderII();

        String startWord = "der", targetWord = "dfs";
        List<String> wordList = Arrays.asList("des",
        "der",
        "dfr",
        "dgt",
        "dfs");

        List<List<String>> ans = obj.findLadders(startWord, targetWord, wordList);
        System.out.println(ans);
    }

    // Problem: https://leetcode.com/problems/word-ladder-ii/
    // Idea: Apply BFS and keep track of all the paths in queue.
    // We need to mark a word as visited only once level if complete as we might need same word in multiple paths
        public List<List<String>> findLadders(String beginWord, String endWord,
                List<String> wordList) {
            Set<String> set = new HashSet<>(wordList);

            Queue<List<String>> q = new LinkedList<>();
            Set<String> vis = new HashSet<>();
            q.add(Arrays.asList(beginWord));
            vis.add(beginWord);

            List<List<String>> ans = new ArrayList<>();
            while (!q.isEmpty()) {
                int size = q.size();
                ArrayList<String> visitedWords = new ArrayList<>();
                for(int k=0; k<size; k++){                      // we need to go level wise as same word might be needed in multiple paths
                    List<String> list = q.remove();
                    String word = list.get(list.size() - 1);
                    if (word.equals(endWord))
                        ans.add(list);

                    for (int i = 0; i < word.length(); i++) {
                        for (char ch = 'a'; ch <= 'z'; ch++) {
                            char wordArray[] = word.toCharArray();
                            wordArray[i] = ch;
                            String transfmdWord = new String(wordArray);
                            if (!set.contains(transfmdWord))
                                continue;

                            if (!vis.contains(transfmdWord)) {
                                ArrayList<String> nlist = new ArrayList<>(list);
                                nlist.add(transfmdWord);
                                q.add(nlist);

                                visitedWords.add(transfmdWord);
                            }
                        }

                    }
                }

                vis.addAll(visitedWords);
                if(!ans.isEmpty())
                    return ans;
            }
            return new ArrayList<>();
        }
}
