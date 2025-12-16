package com.algos.companies.google;

import java.util.*;

import java.util.*;

class TrieNode {
    Map<String, TrieNode> children = new HashMap<>();
    int count = 0;
    boolean isVisited = false;
}

public class Trie_MinimalDirectorySelection {

    private TrieNode root = new TrieNode();

    // Function to insert directories into the Trie
    private void insert(String directory) {
        String[] dirs = directory.split("/");
        TrieNode node = root;
        for (String dir : dirs) {
            if(dir.isEmpty()) continue;

            node.count++;
            node.children.putIfAbsent(dir, new TrieNode());
            node = node.children.get(dir);
        }
    }

    // Function to decrement count for selected directories in the Trie
    private void decrement(String directory) {
        String[] dirs = directory.split("/");
        TrieNode node = root;
        for (String dir : dirs) {
            if(dir.isEmpty()) continue;

            node.count--;
            node = node.children.get(dir);
        }
    }

    // Function to find the common prefixes and add to result
    private void findCommonPrefixes(String directory, List<String> result) {
        StringBuilder prefix = new StringBuilder();
        String[] dirs = directory.split("/");
        TrieNode node = root;
        for (String dir : dirs) {
            if(dir.isEmpty()) continue;

            node = node.children.get(dir);
            prefix.append("/");
            prefix.append(dir);
            if(node.count == 0)
                break;
        }
        if (!node.isVisited) {
            result.add(prefix.toString());
            node.isVisited = true;
        }
    }

    public List<String> getMinimalDirectories(List<String> directories, List<String> selectedDirectories) {
        // Insert all directories into the Trie
        for (String directory : directories) {
            insert(directory);
        }

        // Decrement counts for selected directories
        for (String directory : selectedDirectories) {
            decrement(directory);
        }

        // Find and collect common prefixes for selected directories
        List<String> result = new ArrayList<>();
        for (String directory : selectedDirectories) {
            findCommonPrefixes(directory, result);
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> directories = Arrays.asList(
                "/a/b/x.txt",
                "/a/b/p.txt",
                "/a/c",
                "/a/d/y.txt",
                "/a/d/z.txt"
        );

        List<String> selectedDirectories = Arrays.asList(
                "/a/d/y.txt",
                "/a/d/z.txt",
                "/a/b/p.txt"
        );

        Trie_MinimalDirectorySelection mds = new Trie_MinimalDirectorySelection();
        List<String> result = mds.getMinimalDirectories(directories, selectedDirectories);

        for (String dir : result) {
            System.out.println(dir);
        }
    }
}
