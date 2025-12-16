package li12_trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.algos.topics.models.TrieNode;

public class L1707_MaximumXorWithAnElementFromArray {
    public static void main(String args[]){
        L1707_MaximumXorWithAnElementFromArray obj = new L1707_MaximumXorWithAnElementFromArray();

        int[] nums = new int[]{0,1,2,3,4};
        int[][] queries = new int[][]{{3,1},{1,3},{5,6}};

        int[] ans  = obj.maximizeXor(nums, queries);
        System.out.println(Arrays.toString(ans));
    }

    // Problem: https://leetcode.com/problems/maximum-xor-with-an-element-from-array/description/
    // Idea: Insert all number in trie from msb to lsb (31-0). Insert only the numbers which are less then the query mi.
    // For each query, find the max xor by traversing the trie.
    // max  can be maximized by selecting the bit which is different from the query bit.
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;
        Arrays.sort(nums);
        List<Query> offlineQueries = new ArrayList<>();
        for(int i=0; i<queries.length; i++){
            offlineQueries.add(new Query(i, queries[i][0], queries[i][1]));
        }
        offlineQueries.sort((q1, q2) -> q1.mi-q2.mi);

        Trie2 trie = new Trie2();
        int[] ans = new int[m];
        int ind = 0;
        for(Query q: offlineQueries){
            while(ind<n && nums[ind] <= q.mi){
                trie.insert(nums[ind]);
                ind++;
            }
            if(ind == 0)
                ans[q.index] = -1;
            else
                ans[q.index] = trie.findMax(q.xi);
        }
        return ans;
    }
}

class Query{
    int index;
    int xi;
    int mi;
    Query(int index, int xi, int ai){
        this.index = index;
        this.xi = xi;
        this.mi = ai;
    }
}
class Trie2{
    TrieNode root;
    Trie2(){
        root = new TrieNode();
    }

    public void insert(int num) {
        TrieNode curr = root;
        for(int i=31; i>=0; i--){
            int bit = (num>>i) & 1;
            curr.map.putIfAbsent(bit, new TrieNode());
            curr = curr.map.get(bit);
        }
    }

    public int findMax(int num){
        int max = 0;
        TrieNode curr = root;
        for(int i=31; i>=0; i--){
            int bit = (num>>i) & 1;
            if(curr.map.containsKey(1-bit)){
                max = max | (1<<i);
                curr = curr.map.get(1-bit);
            }else{
                curr = curr.map.get(bit);
            }
        }

        return max;
    }
}
