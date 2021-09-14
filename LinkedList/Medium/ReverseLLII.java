// https://leetcode.com/problems/reverse-linked-list-ii/
import java.util.*;
public class ReverseLLII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int pos =1;
        ListNode temp = head;
        ListNode p1 = null;
        ListNode p2 = p1;
        
        ListNode ch = null;
        ListNode ct = ch;
        while(temp!=null){
            //left zone
            if(pos<left){
                p1=temp;
                temp=temp.next;
            }
            
            // Working zone
            if(pos>=left && pos<=right){
                ListNode n = temp.next;
                temp.next = null;
                if(ch==null){
                    ch=ct=temp;
                }else{
                    temp.next = ch;
                    ch = temp;
                }
                temp=n;
            }
            
            if(pos==right+1){
                p2=temp;
                break;
            }
            pos++;
        }
        
        if(left==1){
            ct.next = p2;
            return ch;
        }
        p1.next = ch;
        ct.next = p2;
        return head;
        
        
    }
}
