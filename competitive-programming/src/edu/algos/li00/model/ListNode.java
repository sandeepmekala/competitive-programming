package edu.algos.li00.model;

import java.util.ArrayList;

public class ListNode {
	public int key;
	public int val;
	public ListNode next;
	public ListNode prev;

	public ListNode(int val){
		this.val = val;
	}

	public ListNode() {
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
	
	public String toString() {
		ArrayList<String> list = new ArrayList<>();
		list.add("["+val+"]");
		ListNode temp = next;
		while(temp !=  null) {
			list.add("["+temp.val+"]");
			temp = temp.next;
		}
		return String.join(" -> ", list);
	}
}
