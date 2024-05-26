package com.algos.core.li09_linkedlist.revised;

public class L369_PlusOneLinkedList {
        
        public static void main(String[] args) {
            L369_PlusOneLinkedList obj = new L369_PlusOneLinkedList();
    
            SingleLinkedList list = new SingleLinkedList();
            list.insertAfterEnd(1);
            list.insertAfterEnd(2);
            list.insertAfterEnd(3);
            list.insertAfterEnd(4);
            list.insertAfterEnd(5);
    
            list.head = obj.plusOne(list.head);
            list.print();

            list.hashCode()
        }
    
        // Problem: https://leetcode.com/problems/plus-one-linked-list/
        // Idea: Use two pointers to keep track of odd
        // TODO: Need to implement
}
