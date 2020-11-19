package leetcode.num.linkedlist;

public class p24_SwapPairs_iteration {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while ( (head != null) && (head.next != null)){
            ListNode first = head;
            ListNode second = head.next;
            first.next = second.next;
            second.next = first;
            pre.next = second;

            pre = first;
            head = first.next;
        }
        return dummy.next;
    }
}
