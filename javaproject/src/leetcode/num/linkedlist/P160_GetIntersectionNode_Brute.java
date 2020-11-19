package leetcode.num.linkedlist;

/**
 * 相交节点：
 *  1. 暴力法
 */
public class P160_GetIntersectionNode_Brute {
    public ListNode getInterSectionNode(ListNode headA, ListNode headB)
    {
        while( headA != null){
            ListNode cur_b = headB;

            while( cur_b != null){
                if (cur_b == headA){
                    return headA;
                }
                cur_b = cur_b.next;
            }
            headA = headA.next;
        }
        return null;
    }
}
