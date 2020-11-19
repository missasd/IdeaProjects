package leetcode.tag.Recursive;

import JavaAlgs.chp2.TreeNode;

public class ReverseLink {
    public LinkNode reverse(LinkNode root){
        if (root == null || root.next == null) return root;
        // 递归反转 子链表
        LinkNode newList = reverse(root.next);
        // 改变 1，2 节点的指向
        // 通过 head.next 获取节点2
        LinkNode t1 = root.next;
        // 让 2 的next指向1
        t1.next = root;
        //  1 的next指向null
        root.next = null;
        return newList;
    }
}
