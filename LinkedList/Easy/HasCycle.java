// https://leetcode.com/problems/linked-list-cycle/
import java.util.*;
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
       ListNode fast = head;
       
       while(fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;
           
           if(slow == fast) {
               return true;
           }
       }
       
       return false;
   }
}
