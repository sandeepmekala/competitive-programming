package edu.ds.linkedlists;

import edu.ds.linkedlist.model.ListNode;

public class SingleLinkedList {

	public ListNode head;
	
	public ListNode getHead() {
		return head;
	}

	public void setHead(ListNode head) {
		this.head = head;
	}

	public static void main(String[] args) {
		SingleLinkedList sll = new SingleLinkedList();
		
//		sll.print();
//		sll.insertAtEnd(10);
//		System.out.println();
//		sll.print();
//		sll.insertAtEnd(20);
//		sll.insertAtEnd(30);
//		System.out.println();
//		sll.print();

//		sll.insertAtBegining(40);
//		System.out.println();
//		sll.print();
//		sll.insertAtBegining(50);
//		System.out.println();
//		sll.print();
		
		sll.insertAtNthPosition(60, 1);
		sll.insertAtNthPosition(70, 2);
		sll.insertAtNthPosition(80, 3);
		System.out.println();
		sll.print();
//		sll.deleteAtNthPosition(1);
//		System.out.println();
//		sll.print();
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
		while(temp.getNext()!= null){
			temp = temp.getNext();
		}
		
		temp.setNext(new ListNode(data));
		
	}
	public void insertAtBegining(int data){
		ListNode node = new ListNode(data);
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
			System.out.print(temp.getData()+" ");
			temp = temp.getNext();
		}
	}
	public void insertAtNthPosition(int data, int n){
		ListNode node  = new ListNode(data);
		if(n == 1){
			head = node;
			return;
		}
		ListNode temp = head;
		for(int i=0; i<n-2; i++){
			temp = temp.getNext();
		}
		node.setNext(temp.getNext());
		temp.setNext(node);
	}
	
	public void deleteAtNthPosition(int n){
		ListNode temp = head;
		if(n == 1){
			head = head.getNext();
			return;
		}
		for(int i=0; i<n-2; i++){
			temp = temp.getNext();
		}

		temp.setNext(temp.getNext().getNext());
	}
	
	public void reverse(){
		ListNode prev = null, current = null, next;
		current = head;
		while(current != null){
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		head = prev;
	}
	
	public void recursivePrint(ListNode node){
		if(node == null){
			return;
		}
		System.out.print(node.getData()+" ");
		recursivePrint(node.getNext());
	}
	
	public void recursiveReversePrint(ListNode node){
		if(node == null){
			return;
		}
		recursiveReversePrint(node.getNext());
		System.out.print(node.getData()+" ");
	}
	public void recursiveReveres(ListNode node){
		if(node.getNext() == null){
			head = node;
			return;
		}
		recursiveReveres(node.getNext());
		ListNode temp = node.getNext();
		temp.setNext(node);
		node.setNext(null);
	}

	public int count() {
		int count = 0;
		ListNode temp = head;
		while(temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}
	
}