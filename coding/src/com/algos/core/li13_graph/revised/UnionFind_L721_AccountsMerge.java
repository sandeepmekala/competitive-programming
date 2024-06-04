package  com.algos.core.li13_graph.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class UnionFind_L721_AccountsMerge {

    private UnionFind_UnionFind uf = new UnionFind_UnionFind();
    public static void main(String[] args) {
        UnionFind_L721_AccountsMerge obj = new UnionFind_L721_AccountsMerge();

        List<List<String>> accounts = new ArrayList<List<String>>();
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        accounts.add(Arrays.asList("Mary","mary@mail.com"));
        accounts.add(Arrays.asList("John","johnnybravo@mail.com"));
        
        System.out.println(obj.accountsMerge(accounts));

    }

    // Problem: https://leetcode.com/problems/accounts-merge/
    // Idea: Use Union find to build unions of accounts. Then merge the lists.
    // Assume list index as node to each entry provided in the list.
    // Assign each mail to its parent node. If mail is already present in map, then union the parent nodes.
    // Create an empty treeset for each node. Add all mails to their parent node's treeset. This merges the mails.
    // Create final list of merged accounts ignoring empty treesets nodes.
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        uf.makeSet(n);
        Map<String, Integer> mailToNodeMap = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(!mailToNodeMap.containsKey(mail)){
                    mailToNodeMap.put(mail, i);
                }else{
                    uf.unionByRank(mailToNodeMap.get(mail), i);
                }
            }
        }

        List<TreeSet<String>> mergedMails =  new ArrayList<>();
        for(int i=0; i<n; i++) 
            mergedMails.add(new TreeSet<>());
        for(String mail: mailToNodeMap.keySet()){
            int parentNode = uf.find(mailToNodeMap.get(mail));
            mergedMails.get(parentNode).add(mail);
        }

        List<List<String>> ans =  new ArrayList<>();
        for(int i=0; i<n; i++){
            if(mergedMails.get(i).size() == 0) 
                continue;
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedMails.get(i));
            ans.add(temp);
        }

        return ans;
    }
}
