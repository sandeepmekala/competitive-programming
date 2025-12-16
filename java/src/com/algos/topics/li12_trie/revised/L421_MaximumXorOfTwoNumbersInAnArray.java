package  com.algos.topics.li12_trie.revised;

import com.algos.topics.models.TrieNode;

public class L421_MaximumXorOfTwoNumbersInAnArray {
    public static void main(String[] args) {
        L421_MaximumXorOfTwoNumbersInAnArray obj = new L421_MaximumXorOfTwoNumbersInAnArray();

        int[] nums = new int[]{3,10,5,25,2,8};
        System.out.println(obj.findMaximumXOR(nums));
    }

    // Problem: https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
    // Idea: Build a trie of all numbers bit from MSB to LSB.
    // For number x, try to find the oposite bit at every position to maximize the xor. If not possible, go with what ever is possible at that level.
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int num: nums){
            trie.insert(num);
        }

        int max = 0;
        for(int num: nums){
            max = Math.max(max, trie.getMax(num));
        }
        return max;
    }
}

class Trie{
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }

    public void insert(int num) {
        TrieNode curr = root;
        for(int i=31; i>=0; i--){
            int bit = (num>>i)&1;
            if(!curr.map.containsKey(bit)){
                curr.map.put(bit, new TrieNode());
            }

            curr = curr.map.get(bit);
        }
    }

    public int getMax(int num){
        TrieNode curr = root;
        int max = 0;
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
