// https://leetcode.com/problems/reorder-list/
import java.util.*;
public class ReorderList {
    public ListNode middle(ListNode head){
        if(head==null)return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode f = curr.next;
            curr.next = prev;
            prev = curr;
            curr = f;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode mid = middle(head);
        ListNode sh = mid.next;
        mid.next=null;
        sh = reverse(sh);
        ListNode c1 = head;
        ListNode c2 = sh;
        
        while(c2!=null){
            ListNode temp1 = c1.next;
            ListNode temp2 = c2.next;
            
            c1.next = c2;
            c2.next = temp1;
            
            c1 = temp1;
            c2=temp2;
        }
    }
}
