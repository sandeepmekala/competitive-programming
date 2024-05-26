package com.algos.core.li09_linkedlist.revised;

import com.algos.core.li30_model.ListNode;

public class DoubleLinkedList {
	private ListNode head;
	
	public static void main(String[] args) {
		DoubleLinkedList dll = new DoubleLinkedList();

		dll.insertBeforeHead(10);
		dll.insertBeforeHead(20);
		dll.insertBeforeHead(30);
		dll.print();
		System.out.println();

		System.out.println("Reverse:");
		dll.head = dll.reverse(dll.head);
		dll.print();
	}
	
	public void insertBeforeHead(int data){
		ListNode node = new ListNode(data);
		if(head == null){
			head = node;
			return;
		}
		head.setPrev(node);
		node.setNext(head);
		head = node;
	}

	public ListNode reverse(ListNode head){
		if(head == null || head.next == null)
			return head;
		
		ListNode curr = head, prv = null;	
		while(curr != null){
			prv = curr.prev;
			curr.prev = curr.next;
			curr.next = prv;
			curr = curr.prev;
		}
		
		return prv.prev;
	}

	public void print(){
		if(head == null){
			System.out.println("List is empty");
			return;
		}
		
		ListNode curr = head;
		while(curr != null){
			System.out.print(curr.getVal()+" ");
			curr = curr.getNext();
		}
	}
}
