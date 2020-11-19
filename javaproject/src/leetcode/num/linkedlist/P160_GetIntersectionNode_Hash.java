package leetcode.num.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class P160_GetIntersectionNode_Hash {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if ( headA == null || headB == null)
            return null;

        Set<ListNode> set = new HashSet<>();

        while ( headA != null){
            set.add(headA);
            headA.next = headA;
        }

        while ( headB != null){
            if ( set.contains(headB))
                return headB;
            headB.next = headB;
        }

        return null;
    }
}
