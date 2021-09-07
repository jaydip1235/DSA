// https://leetcode.com/problems/remove-linked-list-elements/
import java.util.*;
public class RemoveLLElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)return null;
        while(head!=null && head.val==val){
            head = head.next;
        }
        ListNode temp = head;
        while(temp!=null){
            if(temp.next!=null && temp.next.val == val ){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }
}
