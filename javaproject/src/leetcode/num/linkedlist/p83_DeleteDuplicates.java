package leetcode.num.linkedlist;

/**
 *  ListNode cur = head;
 *  等于cur是一个活动的指针
 */
public class p83_DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        while(cur != null && cur.next != null){
            if(cur.val != cur.next.val){
                cur = cur.next;
            }else{
                cur.next = cur.next.next;
            }
        }
        return head;
    }
}
