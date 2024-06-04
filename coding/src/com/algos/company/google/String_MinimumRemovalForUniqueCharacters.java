package com.algos.company.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class String_MinimumRemovalForUniqueCharacters {
    public static int minRemovalsToMakeUnique(String s) {
        if (s == null || s.length() <= 1)
            return 0;

        // Count frequencies of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Use a set to keep track of characters already seen
        Set<Character> seen = new HashSet<>();
        int removals = 0;

        // Traverse the string and calculate removals
        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                // Character is a duplicate, count how many times it needs to be removed
                removals++;
                // Decrease the frequency of this character in the map
                frequencyMap.put(c, frequencyMap.get(c) - 1);
            } else {
                // Character is seen for the first time, add it to the set
                seen.add(c);
            }

            // If frequency of this character in map is zero, remove it from map
            if (frequencyMap.get(c) == 0) {
                frequencyMap.remove(c);
            }
        }

        return removals;
    }

    public static void main(String[] args) {
        String input1 = "abcbbde";
        String input2 = "aaabcdaa";

        System.out.println("Output1: " + minRemovalsToMakeUnique(input1)); // Output: 2
        System.out.println("Output2: " + minRemovalsToMakeUnique(input2)); // Output: 7
    }
}
