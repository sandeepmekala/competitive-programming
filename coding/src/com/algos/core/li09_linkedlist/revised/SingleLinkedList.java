package com.algos.core.li09_linkedlist.revised;

import com.algos.core.li30_model.ListNode;

public class SingleLinkedList {

	public ListNode head;
	
	public static void main(String[] args) {
		SingleLinkedList sll = new SingleLinkedList();
		
		sll.print();
		sll.insertAfterEnd(10);
		System.out.println();
		sll.print();
		sll.insertAfterEnd(20);
		sll.insertAfterEnd(30);
		System.out.println();
		sll.print();

		sll.insertBeforeHead(40);
		System.out.println();
		sll.print();
		sll.insertBeforeHead(50);
		System.out.println();
		sll.print();
		
		sll.insertAtKthPosition(60, 1);
		sll.insertAtKthPosition(70, 2);
		sll.insertAtKthPosition(80, 3);
		System.out.println();
		sll.print();
		
		sll.deleteAtKthPosition(1);
		System.out.println();
		sll.print();
		
		sll.reverse();
		System.out.println();
		sll.print();
	}
	
	public void insertAfterEnd(int data){
		if(head == null){
			ListNode node = new ListNode(data);
			head = node;
			return;
		}
		ListNode temp = head;
		while(temp.next!= null){
			temp = temp.next;
		}
		
		temp.next = new ListNode(data);
		
	}
	public void insertBeforeHead(int data){
		ListNode node = new ListNode(data);
		node.next = head;
		head = node;
	}
	public void print(){
		if(head == null){
			System.out.println("List is empty");
			return;
		}
		
		ListNode temp = head;
		while(temp != null){
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
	public void insertAtKthPosition(int data, int k){
		ListNode node  = new ListNode(data);
		if(k == 1){
			node.next = head;
			head = node;
			return;
		}
		ListNode temp = head;
		for(int i=0; i<k-2; i++){
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
	}
	
	public void deleteAtKthPosition(int k){
		ListNode temp = head;
		if(k == 1){
			head = head.next;
			return;
		}
		for(int i=0; i<k-2; i++){
			temp = temp.next;
		}

		temp.next = temp.next.next;
	}
	
	public void reverse(){
		ListNode prev = null, curr = null, next;
		curr = head;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	
	public void printRec(ListNode node){
		if(node == null){
			return;
		}
		System.out.print(node.val+" ");
		printRec(node.next);
	}
	
	public void reversePrintRec(ListNode node){
		if(node == null){
			return;
		}
		reversePrintRec(node.next);
		System.out.print(node.val+" ");
	}

	public int size() {
		int count = 0;
		ListNode curr = head;
		while(curr != null) {
			curr = curr.next;
			count++;
		}
		return count;
	}
	
}