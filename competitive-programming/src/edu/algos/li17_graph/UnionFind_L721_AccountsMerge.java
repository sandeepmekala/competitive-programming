package edu.algos.li17_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class UnionFind_L721_AccountsMerge {

    private A04_UnionFind uf = new A04_UnionFind();
    public static void main(String[] args) {
        UnionFind_L721_AccountsMerge obj = new UnionFind_L721_AccountsMerge();

        List<List<String>> accounts = new ArrayList<List<String>>();
        accounts.add(new ArrayList<>(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John","johnsmith@mail.com","john00@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("Mary","mary@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John","johnnybravo@mail.com")));
        
        System.out.println(obj.accountsMerge(accounts));

    }

    // Problem: https://leetcode.com/problems/accounts-merge/
    // Idea: Use Union find to build unions of accounts. Then merge the lists.
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        uf.makeSet(n);
        HashMap<String, Integer> mailToNodeMap = new HashMap<>();
        for(int i=0; i<accounts.size(); i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(!mailToNodeMap.containsKey(mail)){
                    mailToNodeMap.put(mail, i);
                }else{
                    uf.unionByRank(mailToNodeMap.get(mail), i);
                }
            }
        }

        List<TreeSet<String>> mergeMails =  new ArrayList<>();
        for(int i=0; i<n; i++) mergeMails.add(new TreeSet<>());
        for(String mail: mailToNodeMap.keySet()){
            int node = uf.find(mailToNodeMap.get(mail));
            mergeMails.get(node).add(mail);
        }
        List<List<String>> ans =  new ArrayList<>();
        for(int i=0; i<n; i++){
            if(mergeMails.get(i).size() == 0) continue;
            ArrayList<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergeMails.get(i));
            ans.add(temp);
        }

        return ans;
    }
}
