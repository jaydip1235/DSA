// https://leetcode.com/problems/reverse-nodes-in-k-group/
import java.util.*;
public class ReverseInKGroup{
    
    public int size(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        return count;
        
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = size(head);
        ListNode ah = null;
        ListNode at = null;
        ListNode temp = head;
        while(count>=k){
            ListNode ch = null;
            ListNode ct = null;
           
            for(int i=1;i<=k;i++){
                ListNode n = temp.next;
                temp.next=null;
                if(ch==null){
                    ch = temp;
                    ct = temp;
                }
                else{
                    temp.next=ch;
                    ch = temp;
                }
                temp = n;
                count--;
            }
            if(ah==null){
                ah = ch;
                at=ct;
            }
            else{
                at.next = ch;
                at = ct;
            }
            
        }
        if(count>0)at.next = temp;
        return ah;
    }
}