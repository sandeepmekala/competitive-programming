package edu.algos.linkedlists;

import edu.algos.linkedlist.model.ListNode;

public class SingleLinkedList {

	public ListNode head;
	
	public static void main(String[] args) {
		SingleLinkedList sll = new SingleLinkedList();
		
		sll.print();
		sll.insertAtEnd(10);
		System.out.println();
		sll.print();
		sll.insertAtEnd(20);
		sll.insertAtEnd(30);
		System.out.println();
		sll.print();

		sll.insertAtBegining(40);
		System.out.println();
		sll.print();
		sll.insertAtBegining(50);
		System.out.println();
		sll.print();
		
		sll.insertAtNthPosition(60, 1);
		sll.insertAtNthPosition(70, 2);
		sll.insertAtNthPosition(80, 3);
		System.out.println();
		sll.print();
		
		sll.deleteAtNthPosition(1);
		System.out.println();
		sll.print();
		
		sll.reverse();
		System.out.println();
		sll.print();
	}
	
	public void insertAtEnd(int data){
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
	public void insertAtBegining(int data){
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
	public void insertAtNthPosition(int data, int n){
		ListNode node  = new ListNode(data);
		if(n == 1){
			node.next = head;
			head = node;
			return;
		}
		ListNode temp = head;
		for(int i=0; i<n-2; i++){
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
	}
	
	public void deleteAtNthPosition(int n){
		ListNode temp = head;
		if(n == 1){
			head = head.next;
			return;
		}
		for(int i=0; i<n-2; i++){
			temp = temp.next;
		}

		temp.next = temp.next.next;
	}
	
	public void reverse(){
		ListNode prev = null, current = null, next;
		current = head;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
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
	public void reveresRec(ListNode node){
		if(node.next == null){
			head = node;
			return;
		}
		reveresRec(node.next);
		ListNode temp = node.next;
		temp.next = node;
		node.next = null;
	}

	public int size() {
		int count = 0;
		ListNode temp = head;
		while(temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}
	
}