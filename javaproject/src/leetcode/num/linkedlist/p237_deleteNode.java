package leetcode.num.linkedlist;


public class p237_deleteNode {
    public void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
