package edu.algos.li13_linkedlist;

import java.util.HashMap;

import edu.algos.li00_model.Node;

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		CopyListWithRandomPointer obj = new CopyListWithRandomPointer(		);
		SingleLinkedList list = new SingleLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		
	}

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        
        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }
        
        Node curr = head;
        while(curr != null){
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
        
    }
}
