package leetcode.num.linkedlist;

/**
 * 判断链表有无环, 排除自环
 */
public class P141_HasCycle {
    public boolean haxCycle(ListNode head){
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
