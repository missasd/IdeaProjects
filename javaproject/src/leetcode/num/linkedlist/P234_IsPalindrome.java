package leetcode.num.linkedlist;

/**
 *  判断链表是否是一个回文链表
 */

import java.util.ArrayList;

public class P234_IsPalindrome {
    public boolean isPalindrome(ListNode head){
        if( head == null || head.next == null) return true;


        // 创建一个列表，并将链表的值加入列表中
        ArrayList<Integer> list = new ArrayList<Integer>();
        while ( head != null){
            list.add(head.val);
            head = head.next;
        }

        int lo = 0;
        int hi = list.size() - 1;

        while ( lo <= hi){
            if (!list.get(lo).equals(list.get(hi))){
                return false;
            }
            lo++;
            hi--;
        }

        return true;

    }
}
