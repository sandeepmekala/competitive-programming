package  com.algos.topics.li09_linkedlist.revised;

import com.algos.topics.models.ListNode;

public class L1290_ConvertBinaryNumberInALinkedListToInteger {

	public static void main(String[] args) {
		L1290_ConvertBinaryNumberInALinkedListToInteger obj = new L1290_ConvertBinaryNumberInALinkedListToInteger();

		SingleLinkedList list = new SingleLinkedList();
		list.insertAfterEnd(0);
		list.insertAfterEnd(1);
		list.insertAfterEnd(1);	// 3

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
