package leetcode.num.linkedlist;

public class P21_mergeTwoLists_twopointer {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode dummy = head;

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null && cur2!= null){
            if(cur1.val <= cur2.val){
                dummy.next = cur1;
                cur1 = cur1.next;
            } else{
                dummy.next = cur2;
                cur2 = cur2.next;
            }
            dummy = dummy.next;
        }
        if(cur1 != null){
            dummy.next = cur1;
        }
        if(cur2 != null){
            dummy.next = cur2;
        }
        return head.next;

    }

}
