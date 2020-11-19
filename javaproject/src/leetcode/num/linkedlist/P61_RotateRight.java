package leetcode.num.linkedlist;

public class P61_RotateRight {
    public ListNode rotateRight(ListNode head, int k){
        if ( head == null) return null;
        if ( head.next == null) return head;

        // 变成环
        ListNode old_tail = head;
        int n;
        for (n=1; old_tail.next!=null; n++){
            old_tail = old_tail.next;
        }
        old_tail.next = head;

        // 新的尾节点位于n-k%n-1索引处，若链表索引从0开始算
        ListNode new_tail = head;
        for (int i = 0; i < n-k%n-1; i++){
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next;

        new_tail.next = null;

        return new_head;
    }
}
