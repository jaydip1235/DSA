// https://leetcode.com/problems/odd-even-linked-list/
import java.util.*;
public class OddEvenLL {
    public ListNode oddEvenList(ListNode head) {
        ListNode oh = new ListNode(-1);
        ListNode ot = oh;
        ListNode eh = new ListNode(-1);
        ListNode et = eh;
        ListNode temp = head;
        int flag=1;
        while(temp!=null){
            if((flag)%2==0){
                et.next = temp;
                et = et.next;
            }
            else{
                ot.next = temp;
                ot = ot.next;
            }
            flag++;
            temp=temp.next;
        }
        et.next = null;
        ot.next = eh.next;
        return oh.next;
    }
}
