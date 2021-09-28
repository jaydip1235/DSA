// https://leetcode.com/problems/linked-list-cycle-ii/
import java.util.*;
public class StartNodeCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
          
          while(fast != null && fast.next != null) {
              slow = slow.next;
              fast = fast.next.next;
              
              if(slow == fast) {
                  //keep fast at meeting point and move to slow to head again, move both pointer by one speed
                  slow = head;
                  
                  while(slow != fast) {
                      slow = slow.next;
                      fast = fast.next;
                  }
                  
                  return slow; //cycle start node
              }
          }
          
          return null;  
      }
}
