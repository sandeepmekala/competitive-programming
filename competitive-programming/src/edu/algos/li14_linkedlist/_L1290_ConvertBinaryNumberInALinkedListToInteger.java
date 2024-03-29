package edu.algos.li14_linkedlist;

import edu.algos.li00_model.ListNode;

public class _L1290_ConvertBinaryNumberInALinkedListToInteger {

	public static void main(String[] args) {
		_L1290_ConvertBinaryNumberInALinkedListToInteger obj = new _L1290_ConvertBinaryNumberInALinkedListToInteger();
		
		_G01_SingleLinkedList list = new _G01_SingleLinkedList();
		list.insertAtEnd(0);
		list.insertAtEnd(1);
		list.insertAtEnd(1);	// 3
		
		System.out.println(obj.getDecimalValue(list.head));
	}

	// Problem: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
	// Idea: Head is MSB. We have to start evaluation from LSB. Hence, use recursive approach.
	int pow = 0;
    public int getDecimalValue(ListNode head) {
        if(head == null) return 0;
		
        int sum = 0;
        sum = getDecimalValue(head.next);
        sum += head.val*Math.pow(2, pow++);
        return sum;
    }
}

