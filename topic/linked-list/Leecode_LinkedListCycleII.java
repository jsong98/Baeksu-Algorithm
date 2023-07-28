package week1.Junseok.leetcode;

public class Leecode_LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
        ListNode pt1 = head;
        ListNode pt2 = head;
        ListNode begin = head;

        while(pt2 != null && pt2.next != null) {
            pt1 = pt1.next;
            pt2 = pt2.next.next;
            
            if(pt1 == pt2) {
                while(pt1 != begin) {
                    pt1 = pt1.next;
                    begin = begin.next;
                }
                return pt1;
            }
        }
        return null;
    }
}
