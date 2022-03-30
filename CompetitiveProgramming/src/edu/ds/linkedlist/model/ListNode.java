package edu.ds.linkedlist.model;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode prev;
	
	private ListNode(){
	}
	
	public ListNode(int data){
		this.val = data;
	}

	public int getData() {
		return val;
	}

	public void setData(int data) {
		this.val = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public ListNode getPrev() {
		return prev;
	}

	public void setPrev(ListNode prev) {
		this.prev = prev;
	}
	
}
