// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
import java.util.*;
public class LLToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)return null;
        int hi = size(head);
        int lo = 0;
        return helper(head,lo,hi);
    }
    
    private TreeNode helper(ListNode head,int lo, int hi){
        if(lo>hi)return null;
        int mididx = (lo+hi)/2;
        ListNode node = get(head,mididx);
        TreeNode nn = new TreeNode(node.val);
        nn.left = helper(head,lo,mididx-1);
        nn.right = helper(head,mididx+1,hi);
        return nn;
    }
    
    private ListNode get(ListNode head,int idx){
        ListNode temp = head;
        while(idx>0){
            temp=temp.next;
            idx--;
        }
        return temp;
    }
        private int size(ListNode head){
        int sz=0;
        ListNode temp = head;
        while(temp!=null){
            sz++;
            temp=temp.next;
        }
        return sz-1;
    }
}
