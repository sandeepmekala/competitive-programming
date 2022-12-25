package edu.algos.li14_linkedlist.medium;

import java.util.HashMap;

import edu.algos.li00_model.Node;
import edu.algos.li14_linkedlist._A01_SingleLinkedList;

public class L138_CopyListWithRandomPointer {

	public static void main(String[] args) {
		L138_CopyListWithRandomPointer obj = new L138_CopyListWithRandomPointer();

		_A01_SingleLinkedList list = new _A01_SingleLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		
	}

    // Problem: https://leetcode.com/problems/copy-list-with-random-pointer/
    // Idea: Use map to store the mapping between node and its copy
    // In first pass create copies of each node and and store
    // In second pass, get the copy of each node and adjust its bext and ran pointers.
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            map.put(curr, newNode);
            curr = curr.next;
        }
        
        curr = head;
        while(curr != null){
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
