package edu.algos.li13_linkedlist;

import edu.algos.li00_model.ListNode;

public class RotateList {

	public static void main(String[] args) {
		RotateList obj = new RotateList();
		
		int k = 2;
		SingleLinkedList list = new SingleLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		
		list.head = obj.rotateRight(list.head, k);
		list.print();
		
	}
	
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        
        int n = 1;
        ListNode curr = head;
        while(curr.next != null){
            n++;
            curr = curr.next;
        }
        curr.next = head;
        
        k = k%n;
        curr = head;
        for(int i=1; i<n-k; i++){
            curr = curr.next;
        }
        
        head = curr.next;
        curr.next = null;
        
        return head;
    }

}
