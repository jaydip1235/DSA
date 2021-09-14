// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
import java.util.*;
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
          return null;
    
        ListNode c1 = head, c2 = head;
        while (n-- > 0)
          c2 = c2.next;
    
        if (c2 == null)
          return head.next;
    
        while (c2.next != null) {
          c1 = c1.next;
          c2 = c2.next;
        }
    
        c1.next = c1.next.next;
        return head;
            
        }
}
