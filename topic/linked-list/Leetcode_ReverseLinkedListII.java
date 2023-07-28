package week1.Junseok.leetcode;

import java.util.Stack;

public class Leetcode_ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int left, int right) {
        Stack<Integer> stack = new Stack<>();

        if(head==null||head.next==null) {
            return head;
        }
        
        ListNode pt = head;

        for(int i = 0; i < left-1; i++) {
            pt = pt.next;
        }

        for(int j = 0; j <= right-left; j++) {
            stack.push(pt.val);
            pt = pt.next;
        }

        pt = head;

        for(int i = 0; i < left-1; i++) {
            pt = pt.next;
        }

        for(int j = 0; j <= right-left; j++) {
            pt.val = stack.peek();
            stack.pop();
            pt = pt.next;
        }

        return head;
    }

}
