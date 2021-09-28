// https://leetcode.com/problems/intersection-of-two-linked-lists/
import java.util.*;
public class IntersectionOfTwoLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //to find the tail
        
        ListNode temp = headA;
        
        while(temp.next != null) {
            temp = temp.next;
        }
        
        ListNode tail = temp;
        
        tail.next = headB; //to create cycle, if there is an intersection point
        
        //this cycle start point is the intersection point
        ListNode slow = headA;
        ListNode fast = headA;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                slow = headA;
                
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                
                tail.next = null;
                return slow;
            }
        }
        
        tail.next = null;
        return null; //there was no intersection point
    } 
}
