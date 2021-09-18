// https://leetcode.com/problems/add-two-numbers-ii/
import java.util.*;
public class AddTwoNumTwo {
    public ListNode reverse(ListNode head){
        ListNode curr = head;
       ListNode prev = null;

       while (curr != null) {
           ListNode n = curr.next;

           curr.next = prev;

           prev = curr;
           curr = n;
       }

       return prev;
   }
   
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode t1 = reverse(l1);
       ListNode t2 = reverse(l2);

       int carry = 0;
       ListNode dh = new ListNode(-1);
       ListNode dt = dh;

       while (t1 != null || t2 != null || carry != 0) {
           int sum = carry;

           if (t1 != null) {
               sum += t1.val;
               t1 = t1.next;
           }
           if (t2 != null) {
               sum += t2.val;
               t2 = t2.next;
           }

           int val = sum % 10;
           carry = sum / 10;

           ListNode nn = new ListNode(val);
           dt.next = nn;
           dt = dt.next;
       }


       ListNode ans = reverse(dh.next);
       return ans;
   }
}
