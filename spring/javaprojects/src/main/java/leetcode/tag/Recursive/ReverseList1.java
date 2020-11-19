package leetcode.tag.Recursive;

public class ReverseList1 {

    public LinkNode reverse(LinkNode head){
        if (head == null || head.next == null) return head;

        LinkNode newList = reverse(head.next);

        return null;

    }
}
