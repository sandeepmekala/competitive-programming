package edu.algos.li14_linkedlist;

import edu.algos.li00_model.ListNode;

public class ConvertBinaryNumberInALinkedListToInteger {

	public static void main(String[] args) {
		ConvertBinaryNumberInALinkedListToInteger obj = new ConvertBinaryNumberInALinkedListToInteger();
		
		SingleLinkedList list = new SingleLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(0);
		list.insertAtEnd(1);
		
		System.out.println(obj.getDecimalValue(list.head));
	}

	int pow = 0;
    public int getDecimalValue(ListNode head) {
        if(head == null) return 0;
        int sum = 0;
        sum = getDecimalValue(head.next);
        sum += head.val*Math.pow(2, pow++);
        return sum;
    }
}

