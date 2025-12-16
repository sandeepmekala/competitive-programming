package li13_graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopoSort_L2115_FindAllPossibleRecipesFromGivenSupplies {
    public static void main(String[] args) {
        TopoSort_L2115_FindAllPossibleRecipesFromGivenSupplies obj = new TopoSort_L2115_FindAllPossibleRecipesFromGivenSupplies();
        String[] recipes = {"A", "B", "C", "D"};
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(List.of("a", "b"));
        ingredients.add(List.of("b", "c"));
        ingredients.add(List.of("c", "d"));
        ingredients.add(List.of("d", "e"));
        String[] supplies = {"a", "b", "c", "d", "e"};
        System.out.println(obj.findAllRecipes(recipes, ingredients, supplies)); // Output: [A, B, C, D]
    }

    public List<String> findAllRecipes(
            String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> g = new HashMap<>();
        Map<String, Integer> indeg = new HashMap<>();
        for (int r = 0; r < recipes.length; ++r) {
            for (String i : ingredients.get(r)) {
                g.putIfAbsent(i, new ArrayList<>());
                g.get(i).add(recipes[r]);
            }
            indeg.put(recipes[r], ingredients.get(r).size());
        }
        Deque<String> q = new ArrayDeque<>();
        for (String s : supplies) {
            q.add(s);
        }

        List<String> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            for (int n = q.size(); n > 0; --n) {
                String i = q.remove();
                for (String j : g.getOrDefault(i, Collections.emptyList())) {
                    indeg.put(j, indeg.get(j) - 1);
                    if (indeg.get(j) == 0) {
                        ans.add(j);
                        q.offer(j);
                    }
                }
            }
        }
        return ans;
    }
}
