package  com.algos.li16_trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import  com.algos.li30_model.TrieNode;

public class L1707_MaximumXorWithAnElementFromArray {
    public static void main(String args[]){
        L1707_MaximumXorWithAnElementFromArray obj = new L1707_MaximumXorWithAnElementFromArray();

        int[] nums = new int[]{0,1,2,3,4};
        int[][] queries = new int[][]{{3,1},{1,3},{5,6}};

        int[] ans  = obj.maximizeXor(nums, queries);
        System.out.println(Arrays.toString(ans));
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n=nums.length, m=queries.length;
        Arrays.sort(nums);
        List<Query> offlineQueries = new ArrayList<>();
        for(int i=0; i<queries.length; i++){
            int q[] = queries[i];
            offlineQueries.add(new Query(i, q[0], q[1]));
        }
        offlineQueries.sort((q1, q2) -> q1.ai-q2.ai);

        Trie trie = new Trie();
        int[] ans = new int[m];
        int ind = 0;
        for(Query q: offlineQueries){
            while(ind<n && nums[ind] <= q.ai){
                trie.insert(nums[ind]);
                ind++;
            }
            if(ind == 0){
                ans[q.index] = -1;
            }else{
                ans[q.index] = trie.findMax(q.xi);
            }
        }
        return ans;
    }
}

class Query{
    int index;
    int xi;
    int ai;
    Query(int index, int xi, int ai){
        this.index = index;
        this.xi = xi; 
        this.ai = ai; 
    }
}
class Trie{
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }

    public void insert(int num) {
        TrieNode current = root;
        for(int i=31; i>=0; i--){
            int bit = (num>>i)&1;
            if(!current.map.containsKey(bit)){
                current.map.put(bit, new TrieNode());
            }

            current = current.map.get(bit);
        }
    }

    public int findMax(int num){
        TrieNode current = root;
        int max = 0;
        for(int i=31; i>=0; i--){
            int bit = (num>>i) & 1;
            if(current.map.containsKey(1-bit)){
                max = max | (1<<i);
                current = current.map.get(1-bit);
            }else{
                current = current.map.get(bit);
            }
        }
        return max;
    }
}
