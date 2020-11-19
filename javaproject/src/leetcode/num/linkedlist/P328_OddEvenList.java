package leetcode.num.linkedlist;

public class P328_OddEvenList {
    public ListNode oddEvenList(ListNode head){
        if (head == null) return null;
        ListNode oddHead = head;
        ListNode odd = head;
        ListNode evenHead = odd.next;
        ListNode even = odd.next;

        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
