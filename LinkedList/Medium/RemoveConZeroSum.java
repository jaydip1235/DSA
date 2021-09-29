// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
import java.util.*;
public class RemoveConZeroSum {
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer,ListNode> hm = new HashMap<>();
        
        int psum = 0;
        ListNode dh = new ListNode(1001);
        dh.next=head;
        
        hm.put(psum,dh);
        ListNode temp = head;
        while(temp!=null){
            psum+=temp.val;
            if(hm.containsKey(psum)){
                ListNode pre = hm.get(psum);
                ListNode toRemove = pre.next;
                int sum=psum;
                while(toRemove!=temp){
                    sum+=toRemove.val;
                    hm.remove(sum);
                    toRemove = toRemove.next;
                }
                pre.next=temp.next;
            }
            else{
                hm.put(psum,temp);
            }
            temp=temp.next;
        }
      
        return dh.next;
    }
}
