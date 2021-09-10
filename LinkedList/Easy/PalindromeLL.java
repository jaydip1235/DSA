// https://leetcode.com/problems/palindrome-linked-list/
import java.util.*;
public class PalindromeLL {
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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)return true;
        ListNode mid = middle(head);
        ListNode sh = mid.next;
        mid.next = null;
        sh = reverse(sh);
        ListNode c1 = head;
        ListNode c2 = sh;
        while(c2!=null){
            if(c1.val!=c2.val)return false;
            c1=c1.next;
            c2=c2.next;
        }
        sh = reverse(sh);
        mid.next = sh;
        return true;
    }
}
