// https://leetcode.com/problems/partition-list/
import java.util.*;
public class Partition {
    public ListNode partition(ListNode head, int x) {
        if(head==null)return head;
    
        ListNode sh = new ListNode(-1);
        ListNode st = sh;

        ListNode lh = new ListNode(-1);
        ListNode lt = lh;

        ListNode temp = head;

        while (temp != null) {
         if (temp.val < x) {
                st.next = temp;
                st = st.next;
            } else if (temp.val >= x) {
                lt.next = temp;
                lt = lt.next;
            }
            temp = temp.next;
        }

        lt.next = null;

        st.next = lh.next;

        return sh.next;
    }
}
