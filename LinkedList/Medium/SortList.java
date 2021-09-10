// https://leetcode.com/problems/sort-list/
import java.util.* ;
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null)return null;
         if(head.next == null) {
            return head;
        }
        ListNode mid = middle(head);
        ListNode sh = mid.next;
        mid.next=null;
        ListNode lp = sortList(head);
        ListNode rp = sortList(sh);
        ListNode merge = mergeTwoLists(lp,rp);
        return merge;
        
    }
    public static ListNode middle(ListNode head) {
        if(head == null) {
            return null;
        }    
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dh = new ListNode(-1);
        ListNode dt = dh;
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                dt.next = p1;
                p1 = p1.next;
            }
            else {
                dt.next = p2;
                p2 = p2.next;
            }
            dt = dt.next;
        }
        
        if(p1 != null) {
            dt.next = p1;
        }
        
        if(p2 != null) {
            dt.next = p2;
        }
        
        return dh.next;
    }
}
