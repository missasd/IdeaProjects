//import leetcode.num.linkedlist.ListNode;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class IsPalindrome {
//
//    public boolean check(ListNode root){
//        List<Integer> list = new ArrayList<>();
//        ListNode curr = root;
//        if(root == null) return false;
//        while (curr != null){
//            list.add(curr.val);
//            curr = curr.next;
//        }
//        return helper(list);
//
//    }
//
//    private boolean helper(List<Integer> list){
//        int n = list.size();
//        if(n == 0) return false;
//        int i = 0;
//        int j = n - 1;
//        while (i <= j){
//            if (list.get(i) != list.get(j)) {
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }
//}
