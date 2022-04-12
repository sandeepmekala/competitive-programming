package edu.ds.linkedlist.model;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode prev;

	public ListNode(int data){
		this.val = data;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
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
