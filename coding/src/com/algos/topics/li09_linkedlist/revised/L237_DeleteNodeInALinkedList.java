package  com.algos.topics.li09_linkedlist.revised;

import com.algos.topics.models.ListNode;

public class L237_DeleteNodeInALinkedList {
    public static void main(String[] args) {

    }

    // Problem: https://leetcode.com/problems/delete-node-in-a-linked-list/
    // Idea: Just swap the curr node val with next node val and delete next node.
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
