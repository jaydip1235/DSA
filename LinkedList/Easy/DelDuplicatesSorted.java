// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
import java.util.*;
public class DelDuplicatesSorted {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode dummy = new ListNode(-(int)1e8);
        ListNode itr = dummy, curr = head;
        while(curr!=null){
            while(curr!=null && curr.val == itr.val)curr = curr.next;
            itr.next = curr;
            itr = itr.next;
        }
        return dummy.next;
    }
}
