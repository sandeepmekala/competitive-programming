package  com.algos.li14_linkedlist;

import  com.algos.li30_model.ListNode;

public class _L237_DeleteNodeInALinkedList {
    public static void main(String[] args) {
        
    }

    // Problem: https://leetcode.com/problems/delete-node-in-a-linked-list/
    // Idea: Just swap the curr node val with next node val and delete next node.
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
