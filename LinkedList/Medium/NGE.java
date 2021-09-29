// https://leetcode.com/problems/next-greater-node-in-linked-list/
import java.util.*;
public class NGE {
    public int[] nextLargerNodes(ListNode head) {
        int n = size(head);
        int ans[] = new int[n];
        Stack<ListNode> st = new Stack<>();
        ListNode nh = reverse(head);
        ListNode temp = nh.next;
        st.push(nh);
        ans[n-1]=0;
        int idx=n-2;
        while(temp!=null){
            while(st.size()>0 && st.peek().val<=temp.val)st.pop();
            if(st.size()==0){
                ans[idx]=0;
            }
            else{
               ans[idx]=st.peek().val;
            }
            st.push(temp);
            temp=temp.next;
            idx--;
            
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
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode forw = curr.next;

            curr.next = prev;

            prev = curr;
            curr = forw;
        }

        return prev;
    }
}
