//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
import java.util.*;
public class RemoveDupII{
     public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode dh = new ListNode(-1);
        ListNode dt=dh;
        
        ListNode itr=head;
        ListNode curr=itr.next;
        
        dt.next=itr;
        
        while(curr!=null)
        {
            boolean isDuplicate = false;
            while(curr!=null && itr.val==curr.val){
                isDuplicate = true;
                curr=curr.next;
            }
            if(!isDuplicate)dt=dt.next;
            else dt.next=curr;
            itr=curr;
            if(itr!=null)
            curr=itr.next;
        }
        return dh.next;
    }
}