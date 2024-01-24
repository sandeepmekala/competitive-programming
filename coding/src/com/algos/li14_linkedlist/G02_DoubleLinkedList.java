package com.algos.li14_linkedlist;

import com.algos.li30_model.ListNode;

public class G02_DoubleLinkedList {
	private ListNode head;
	
	public static void main(String[] args) {
		G02_DoubleLinkedList dll = new G02_DoubleLinkedList();

		dll.insertAtHead(10);
		dll.insertAtHead(20);
		dll.insertAtHead(30);
		dll.print();
		System.out.println();
		System.out.println("Reverse Print:");
		dll.reversePrint();
	}
	
	public void insertAtHead(int data){
		ListNode node = new ListNode(data);
		if(head == null){
			head = node;
			return;
		}
		head.setPrev(node);
		node.setNext(head);
		head = node;
	}
	public void print(){
		if(head == null){
			System.out.println("List is empty");
			return;
		}
		
		ListNode temp = head;
		while(temp != null){
			System.out.print(temp.getVal()+" ");
			temp = temp.getNext();
		}
	}
	public void reversePrint(){
		if(head == null){
			System.out.println("List is empty");
		}
		ListNode temp = head;
		while(temp.getNext() != null){
			temp = temp.getNext();
		}
		while(temp != null){
			System.out.print(temp.getVal()+" ");
			temp = temp.getPrev();
		}
	}
}
