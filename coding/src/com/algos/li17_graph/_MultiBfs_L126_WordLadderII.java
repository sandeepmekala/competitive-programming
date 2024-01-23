package  com.algos.li17_graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class _MultiBfs_L126_WordLadderII {
    public static void main(String[] args) throws IOException {
        _MultiBfs_L126_WordLadderII obj = new _MultiBfs_L126_WordLadderII();

        String startWord = "der", targetWord = "dfs";
        List<String> wordList = Arrays.asList("des",
        "der",
        "dfr",
        "dgt",
        "dfs");

        List<List<String>> ans = obj.findLadders(startWord, targetWord, wordList);
        System.out.println(ans);
    }

    public List<List<String>> findLadders(String beginWord, String endWord,
            List<String> wordList) {
        Set<String> set = new HashSet<String>(wordList);

        Queue<List<String>> q = new LinkedList<>();
        q.add(Arrays.asList(beginWord));
        set.remove(beginWord);

        List<List<String>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<String> usedWords = new ArrayList<>();
            for(int k=0; k<size; k++){
                List<String> list = q.remove();
                String word = list.get(list.size() - 1);
                if (word.equals(endWord)) 
                    ans.add(list);

                for (int i = 0; i < word.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char replacedCharArray[] = word.toCharArray();
                        replacedCharArray[i] = c;
                        String replacedWord = new String(replacedCharArray);

                        if (set.contains(replacedWord)) {
                            ArrayList<String> nlist = new ArrayList<>(list);
                            nlist.add(replacedWord);
                            q.add(nlist);

                            usedWords.add(replacedWord);
                        }
                    }

                }
            }

            set.removeAll(usedWords);            
            if(!ans.isEmpty())
                return ans;
        }
        return new ArrayList<>();
    }
}
