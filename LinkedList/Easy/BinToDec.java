// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
import java.util.*;
public class BinToDec{
     public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int getDecimalValue(ListNode head) {
        if(head==null)return 0;
        int s = size(head);
        s-=1;
        ListNode temp=head;
        int ans=0;
        while(temp!=null){
            ans+=Math.pow(2,s)*temp.val;
            s--;
            temp=temp.next;
        }
        return ans;
    }
    
    private int size(ListNode head){
        int sz=0;
        ListNode temp = head;
        while(temp!=null){
            sz++;
            temp=temp.next;
        }
        return sz;
    }
}